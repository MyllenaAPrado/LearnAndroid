package com.example.apptolearn.barcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apptolearn.R
import com.example.apptolearn.databinding.BarcodeBinding

internal class BarcodeFragment : Fragment(R.layout.barcode){

    private lateinit var viewModel: BarcodeViewModel
    private lateinit var binding: BarcodeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = BarcodeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(BarcodeViewModel::class.java)



        return binding.root
    }

    companion object{
        fun newInstance(): BarcodeFragment{
            return BarcodeFragment()
        }

    }

}