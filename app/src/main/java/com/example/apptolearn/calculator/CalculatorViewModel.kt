package com.example.apptolearn.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

internal class CalculatorViewModel : ViewModel(){

    // The output screen
    private val _screen = MutableLiveData<String>()
    val screen: LiveData<String> = _screen

    // The operation
    private val _operation = MutableLiveData<String>()
    val operation: LiveData<String> = _operation

    //number
    private val _number = MutableLiveData<Double>()
    val number: LiveData<Double> = _number

    //number
    private val _number1 = MutableLiveData<Double>()
    val number1: LiveData<Double> = _number1

    //number
    private val _number2 = MutableLiveData<Double>()
    val number2: LiveData<Double> = _number2

    //result
    private val _result = MutableLiveData<Double>()
    val result: LiveData<Double> = _result

    init {
        _screen.value = ""
        _number.value = 0.0

    }

    fun add_digit(digit: Double){
        _screen.value = _screen.value.plus(digit.toInt().toString())
        if(_number.value == 0.0){
            _number.value = digit

        }
        else{
            _number.value = _number.value?.times(10)
            _number.value = _number.value?.plus(digit)
        }

    }

    fun set_operation(option : String){
        _operation.value = option
        _number1.value = _number.value
        _number.value = 0.0

        if(_operation.value == "sum") _screen.value = _screen.value.plus(" + ")
        if(_operation.value == "sub") _screen.value = _screen.value.plus(" - ")
        if(_operation.value == "div") _screen.value = _screen.value.plus(" / ")
        if(_operation.value == "mul") _screen.value = _screen.value.plus(" * ")

    }

    //do the operation
    fun execute_operation(){
        if(_number1.value != 0.0 && _number.value != 0.0){
            _number2.value = _number.value
            if(_operation.value == "sum") _result.value = _number1.value?.plus(_number2.value!!)
            if(_operation.value == "sub") _result.value = _number1.value?.minus(_number2.value!!)
            if(_operation.value == "div") _result.value = _number1.value?.div(_number2.value!!)
            if(_operation.value == "mul") _result.value = _number1.value?.times(_number2.value!!)
            _screen.value = "${_result.value} \n"
            _number.value = 0.0
        }
    }


}