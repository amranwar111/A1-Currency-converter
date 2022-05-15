package com.a1.domain.repository

import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {
    suspend fun getLanguage(): Flow<String>
    suspend fun setLanguage(lang: String)
}