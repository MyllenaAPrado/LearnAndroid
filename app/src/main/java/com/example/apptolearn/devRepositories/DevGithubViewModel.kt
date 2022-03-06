package com.example.apptolearn.devRepositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray


internal class DevGithubViewModel :  ViewModel(){

    companion object {
        val TAG = "GITHUB"
    }

    private val GITAPI= "https://api.github.com"
    private val USER = "MyllenaAPrado"

    private val _repositoryData = MutableLiveData<String>()
    val repositoryData: LiveData<String> = _repositoryData

    private val _onGetRepository = MutableLiveData<Boolean>()
    val onGetRepository : LiveData<Boolean> = _onGetRepository

    private val _pogressBar = MutableLiveData<Int>()
    val pogressBar : LiveData<Int> = _pogressBar


    init {
        _onGetRepository.postValue(false)
        viewModelScope.launch() {
            setProgress()
        }
        viewModelScope.launch() {
            execute_getRepositories()
        }

    }

    private suspend fun setProgress() {
        withContext(Dispatchers.Default) {
            var i = 0
            while (_onGetRepository.value == true) {
                _pogressBar.postValue(i++)
            }
        }
    }

    private suspend fun execute_getRepositories() {
        withContext(Dispatchers.Default) {
            delay(5000)
            AndroidNetworking.get("${GITAPI}/users/${USER}/repos?type=public")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(object : JSONArrayRequestListener {
                    override fun onResponse(response: JSONArray) {
                        var data = "Repositories from Github: \n\n"
                        var size = response.length() - 1
                        for (i in 0..size) {
                            var resp_json = response.getJSONObject(i)
                            var name = resp_json.getString("name")
                            var url = resp_json.getString("url")
                            var description = resp_json.getString("description")
                            data += "Repository: ${name} \n" +
                                        "Description: ${description} \n" +
                                        "URL: ${url} \n\n"
                            Log.d(TAG, "Name: ${data}")

                            _repositoryData.postValue(data)
                        }

                    }

                    override fun onError(anError: ANError?) {
                        Log.e(TAG, "Error ${anError?.message}")
                        _repositoryData.postValue("Error: ${anError?.message}")
                    }
                })

            _onGetRepository.postValue(true)
        }
    }
}
