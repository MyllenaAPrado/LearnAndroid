package com.example.apptolearn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apptolearn.barcode.BarcodeFragment
import com.example.apptolearn.databinding.InitialScreenBinding
import com.example.apptolearn.menulist.MenuOptions

internal class InitialScreen : Fragment(R.layout.initial_screen) {
    private lateinit var binding: InitialScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        
        binding = InitialScreenBinding.inflate(layoutInflater)
        binding.imageView.setImageResource(R.mipmap.ic_init_learn_foreground)
        binding.buttonMenu.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, MenuOptions.newInstance())
                .addToBackStack(null)
                .commit()
        }

        binding.buttonBarcode.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, BarcodeFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }

        return this.binding.root
    }

}