package com.a1.domain.exceptions

sealed class LocalExceptions : Exception() {
    object UnknownException : LocalExceptions()
    object TimeoutException : LocalExceptions()
}