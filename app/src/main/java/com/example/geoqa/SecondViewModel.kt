package com.example.geoqa

import androidx.lifecycle.MutableLiveData

class SecondViewModel {
    var map:MutableLiveData<HashMap<String,Boolean>> = MutableLiveData()
    init {
        map.apply {

        }
    }
}