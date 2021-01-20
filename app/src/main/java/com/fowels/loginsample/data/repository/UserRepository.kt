
package com.fowels.loginsample.data.repository

import com.fowels.loginsample.data.network.UserApi

class UserRepository(
    private val api: UserApi
) : BaseRepository() {

    suspend fun getUser() = safeApiCall {
        api.getUser()
    }
}