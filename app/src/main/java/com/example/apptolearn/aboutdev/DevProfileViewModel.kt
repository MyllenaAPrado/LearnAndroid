package com.example.apptolearn.aboutdev

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptolearn.R

internal class DevProfileViewModel : ViewModel(){

    private val _profileInfo: MutableLiveData<DevInfo> = MutableLiveData()
    val profileInfo: LiveData<DevInfo> = _profileInfo

    fun loadProfile() {
        _profileInfo.value = DevInfo(
            profileImage = R.mipmap.ic_about_dev,
            headerImage = R.mipmap.ic_background_dev,
            name = R.string.user_name,
            bio = R.string.user_bio
        )
    }

}