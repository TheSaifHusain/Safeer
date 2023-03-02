package com.thesaifhusain.safeer.domain

sealed class ResultState<out T> {

    data class Success<out R> (val data : R) : ResultState<R>()
    data class Failure(val massage : Throwable) : ResultState<Nothing>()
    object Loading : ResultState<Nothing>()
}
