package com.joaovitor.coinappmb.repository

data class Resource<T>(val status: Status, val data: T?, val message: String?){
    companion object{
        fun <T> success(data: T): Resource<T> = Resource(Status.SUCCESS, data, null)
        fun <T> error(data: T?,  message: String): Resource<T> = Resource(Status.ERROR, data, message)
    }
}