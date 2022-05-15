package com.aait.data.repository

import com.aait.data.datasource.PreferenceDataSource
import com.aait.data.local.utils.PreferenceConstants
import com.aait.data.remote.utils.NetworkConstants.Languages.ARABIC
import com.aait.domain.repository.PreferenceRepository
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