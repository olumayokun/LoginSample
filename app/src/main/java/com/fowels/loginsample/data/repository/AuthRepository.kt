package com.fowels.loginsample.data.repository

import com.fowels.loginsample.data.UserPreferences
import com.fowels.loginsample.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi,
    private val preferences: UserPreferences
) : BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }

    suspend fun saveAuthToken(authToken: String) {
        preferences.saveAuthToken(authToken)
    }
}