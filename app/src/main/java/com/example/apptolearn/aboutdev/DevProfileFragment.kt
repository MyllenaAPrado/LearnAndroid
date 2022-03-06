package com.example.apptolearn.aboutdev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apptolearn.R
import com.example.apptolearn.databinding.AboutDevBinding
import com.example.apptolearn.devRepositories.DevGithubFragment

internal class DevProfileFragment : Fragment(R.layout.about_dev) {

    private lateinit var viewModel: DevProfileViewModel
    private lateinit var binding: AboutDevBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = AboutDevBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(DevProfileViewModel::class.java)
        viewModel.profileInfo.observe(viewLifecycleOwner, ::updateUi)
        viewModel.loadProfile()

        binding.buttonGithub.setOnClickListener(){
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, DevGithubFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        binding.buttonBackDev.setOnClickListener(){
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    private fun updateUi(devInfo: DevInfo) = binding.run {
        imageBackground.setImageResource(devInfo.headerImage)
        imageDev.setImageResource(devInfo.profileImage)
        textDevName.setText(devInfo.name)
        textBio.setText(devInfo.bio)
    }


    companion object {
        fun newInstance(): DevProfileFragment {
            return DevProfileFragment()
        }
    }

}
