package com.example.apptolearn.devRepositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androidnetworking.AndroidNetworking
import com.example.apptolearn.R
import com.example.apptolearn.databinding.GithubOverviewBinding

class DevGithubFragment : Fragment(R.layout.github_overview){

    private lateinit var viewModel: DevGithubViewModel
    private lateinit var binding: GithubOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{

        val onClickListener = ItemClickListener { option ->
            println(option.repositoryName)
        }
        binding = GithubOverviewBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(DevGithubViewModel::class.java)

        AndroidNetworking.initialize(this.activity)

        viewModel.onGetRepository.observe(viewLifecycleOwner, Observer {
            when(it){
                false ->{
                    binding.progressbarGithub.visibility = View.VISIBLE
                }
                true ->{
                    binding.progressbarGithub.visibility = View.INVISIBLE
                }

            }
        })
        viewModel.pogressBar.observe(viewLifecycleOwner, Observer {
            binding.progressbarGithub.progress = it
        })

        viewModel.repositoryData.observe(viewLifecycleOwner, Observer {
            binding.githubData.text = it

        })

        return this.binding.root

    }

    companion object {
        fun newInstance(): DevGithubFragment{
            return DevGithubFragment()
        }

    }
}