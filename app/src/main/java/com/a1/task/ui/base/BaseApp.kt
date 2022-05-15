package com.a1.task.ui.base

import android.content.Context
import com.a1.data.remote.utils.NetworkConstants.Languages.ARABIC
import com.a1.utils.common.ThemeHelper
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