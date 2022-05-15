package com.a1.data.repository

import com.a1.data.datasource.PreferenceDataSource
import com.a1.data.local.utils.PreferenceConstants
import com.a1.data.remote.utils.NetworkConstants.Languages.ARABIC
import com.a1.domain.repository.PreferenceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(private val preferenceDataSource: PreferenceDataSource) :
    PreferenceRepository {

    override suspend fun getLanguage(): Flow<String> = flow {
        preferenceDataSource.getValue(PreferenceConstants.LANGUAGE, ARABIC).collect {
            emit(it as String)
        }
    }

    override suspend fun setLanguage(lang: String) {
        return preferenceDataSource.setValue(PreferenceConstants.LANGUAGE, lang)
    }
}