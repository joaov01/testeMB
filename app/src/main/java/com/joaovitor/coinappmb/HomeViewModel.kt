package com.joaovitor.coinappmb

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joaovitor.coinappmb.data.ApiClient
import com.joaovitor.coinappmb.repository.Repository
import com.joaovitor.coinappmb.repository.Resource
import com.joaovitor.coinappmb.ui.model.response.Exchange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(private val repository: Repository): ViewModel() {

    private val _data = MutableLiveData<List<Exchange>>()
    val data: LiveData<List<Exchange>> get() = _data

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean> = _isError

    fun fetchExchange() {

        CoroutineScope(Dispatchers.Main).launch {
            _isLoading.value = true

            try {
                val exchanges = withContext(Dispatchers.IO) {
                    repository.fetchExchange()
                }
                _data.postValue(exchanges)
                _isLoading.value = false

            } catch (t: Throwable) {
                _isError.postValue(true)
                _isLoading.value = false
            }
        }
    }
}