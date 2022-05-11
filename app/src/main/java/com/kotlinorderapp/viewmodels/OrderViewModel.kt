package com.kotlinorderapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _coffeeName = MutableLiveData<String>()
    val coffeeName: LiveData<String> get() = _coffeeName

    private val _coffeePrice = MutableLiveData(0.0)
    val coffeePrice: LiveData<Double> get() = _coffeePrice

    private val _coffeeCount = MutableLiveData(1)
    val coffeeCount: LiveData<Int> get() = _coffeeCount

    private val _total = MutableLiveData(0.0)
    val total: LiveData<Double> get() = _total

    fun setCoffeeInfo(coffeeName: String, coffeePrice: Double) {
        _coffeeName.value = coffeeName
        _coffeePrice.value = coffeePrice
        _total.value = coffeePrice
    }

    fun resetOrder() {
        _coffeeName.value = ""
        _coffeePrice.value = 0.0
        _coffeeCount.value = 1
    }

    fun incCoffeeCount() {
        _coffeeCount.value = _coffeeCount.value?.inc()
        uptadeTotalPrice(true)
    }

    fun decCoffeeCount() {
        if (_coffeeCount.value!! > 1) {
            _coffeeCount.value = _coffeeCount.value?.dec()
            uptadeTotalPrice(false)
        }
    }

    private fun uptadeTotalPrice(process: Boolean) {
        if (process) {
            _total.value = _total.value?.plus(_coffeePrice.value!!)
        } else {
            _total.value = _total.value?.minus(_coffeePrice.value!!)
        }
    }
}