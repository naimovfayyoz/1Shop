package uz.fayyoz.a1shop.utill.network

import androidx.lifecycle.MutableLiveData

object Variables {
    var isNetworkConnected = MutableLiveData<Event<Boolean>>()
}