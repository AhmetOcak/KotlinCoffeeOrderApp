package com.kotlinorderapp.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _coffeeName = MutableLiveData<String>()
    val coffeeName: LiveData<String> get() = _coffeeName

    private val _coffeePrice = MutableLiveData<String>()
    val coffeePrice: LiveData<String> get() = _coffeePrice

    private val _coffeeCount = MutableLiveData(1)
    val coffeeCount: LiveData<Int> get() = _coffeeCount

    fun setCoffeeInfo(coffeeName : String, coffeePrice : String) {
        _coffeeName.value = coffeeName
        _coffeePrice.value = coffeePrice
    }

    fun resetOrder() {
        _coffeeName.value = ""
        _coffeePrice.value = ""
        _coffeeCount.value = 1
    }

    fun incCoffeeCount() {
        _coffeeCount.value = _coffeeCount.value?.inc()
    }

    fun decCoffeeCount() {
        if(_coffeeCount.value!! > 1) _coffeeCount.value = _coffeeCount.value?.dec()
    }
}