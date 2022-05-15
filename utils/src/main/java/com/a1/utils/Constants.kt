package com.a1.utils

import java.util.*

object Constants {

    const val TAG = "AppDebug"
    const val DEBUG = true

    val language: String
        get() {
            return Locale.getDefault().language
        }
}