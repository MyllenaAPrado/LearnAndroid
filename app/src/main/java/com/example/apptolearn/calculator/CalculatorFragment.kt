package com.example.apptolearn.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apptolearn.R
import com.example.apptolearn.databinding.CalculatorBinding


internal class CalculatorFragment : Fragment(R.layout.calculator) {

    private lateinit var viewModel: CalculatorViewModel
    private lateinit var binding: CalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CalculatorBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)

        viewModel.screen.observe(viewLifecycleOwner, ::update_UI)

        //add number 0
        binding.buttonCalculator.setOnClickListener(){
            viewModel.add_digit(0.0)
        }

        //add number 1
        binding.buttonCalculator1.setOnClickListener(){
            viewModel.add_digit(1.0)
        }

        //add number 2
        binding.buttonCalculator2.setOnClickListener(){
            viewModel.add_digit(2.0)
        }

        //add number 3
        binding.buttonCalculator3.setOnClickListener(){
            viewModel.add_digit(3.0)
        }

        //add number 4
        binding.buttonCalculator4.setOnClickListener(){
            viewModel.add_digit(4.0)
        }

        //add number 5
        binding.buttonCalculator5.setOnClickListener(){
            viewModel.add_digit(5.0)
        }

        //add number 6
        binding.buttonCalculator6.setOnClickListener(){
            viewModel.add_digit(6.0)
        }

        //add number 7
        binding.buttonCalculator7.setOnClickListener(){
            viewModel.add_digit(7.0)
        }

        //add number 8
        binding.buttonCalculator8.setOnClickListener(){
            viewModel.add_digit(8.0)
        }

        //add number 9
        binding.buttonCalculator9.setOnClickListener(){
            viewModel.add_digit(9.0)
        }

        //set operation +
        binding.buttonCalculatorSum.setOnClickListener(){
            viewModel.set_operation("sum")
        }

        //set operation -
        binding.buttonCalculatorSub.setOnClickListener(){
            viewModel.set_operation("sub")
        }

        //set operation divide
        binding.buttonCalculatorDiv.setOnClickListener(){
            viewModel.set_operation("div")
        }

        //set operation multiply
        binding.buttonCalculatorMult.setOnClickListener(){
            viewModel.set_operation("mul")
        }

        //get the result of operation
        binding.buttonCalculatorEnter.setOnClickListener(){
            viewModel.execute_operation()
        }

        binding.buttonCalculatorBack.setOnClickListener(){
            parentFragmentManager.popBackStack()
        }

        return binding.root

    }

    private fun update_UI(screen_output:String){
        binding.textViewCalculatorResult.text = screen_output

    }

    companion object {
        fun newInstance(): CalculatorFragment {
            return CalculatorFragment()
        }
    }

}
