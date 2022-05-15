package com.aait.domain.repository

import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {
    suspend fun getLanguage(): Flow<String>
    suspend fun setLanguage(lang: String)
}