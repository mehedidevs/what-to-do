package com.mehedi.whattodo.data


/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<T>(val da: T? = null, val e: Exception? = null) {
    data class Success<T>(val data: T) : Result<T>(data)
    data class Error(val exception: Exception) : Result<Exception>(exception)
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}
