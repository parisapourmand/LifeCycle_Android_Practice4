package com.example.exercise4

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    init {
        Log.i("MainViewModel", "View Model created")
    }

    //TODO Encapsulation
    private var _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() {
            return  _score
        }

    fun  add(num : Int){
        _score.value = num
        _score.value = (_score.value)?.plus(1)
    }

    fun  reduce(num : Int){
        _score.value = num
        _score.value = (_score.value)?.minus(1)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MainViewModel", "View Model Cleared")
    }

}