package com.a1.task.ui.utils

import com.a1.domain.exceptions.NetworkExceptions
import com.a1.task.R

fun Throwable.getIsCommonException(): Int {
    when (this) {
        is NetworkExceptions.ConnectionException -> {
            return R.string.error_connection
        }

        is NetworkExceptions.NotFoundException -> {
            return R.string.error_not_found
        }

        is NetworkExceptions.ServerException -> {
            return R.string.error_server
        }

        is NetworkExceptions.TimeoutException -> {
            return R.string.error_timeout
        }

        is NetworkExceptions.UnknownException -> {
            return R.string.error_unknown
        }

        else -> {
            return R.string.error_unknown
        }
    }
}