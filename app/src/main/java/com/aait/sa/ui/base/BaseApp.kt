package com.aait.sa.ui.base

import android.content.Context
import com.aait.data.remote.utils.NetworkConstants.Languages.ARABIC
import com.aait.utils.common.ThemeHelper
import com.akexorcist.localizationactivity.ui.LocalizationApplication
import dagger.hilt.android.HiltAndroidApp
import java.util.*

@HiltAndroidApp
class BaseApp : LocalizationApplication() {

    override fun getDefaultLanguage(base: Context): Locale {
        return Locale(ARABIC)
    }

    override fun onCreate() {
        super.onCreate()
        ThemeHelper.applyTheme(ThemeHelper.ThemeMode.LIGHT)
    }
}