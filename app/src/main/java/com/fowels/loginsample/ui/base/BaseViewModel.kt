package com.fowels.loginsample.ui.base

import androidx.lifecycle.ViewModel
import com.fowels.loginsample.data.network.UserApi
import com.fowels.loginsample.data.repository.BaseRepository

abstract class BaseViewModel(
        private val repository: BaseRepository
) : ViewModel() {

    suspend fun logout(api: UserApi) = repository.logout(api)
}