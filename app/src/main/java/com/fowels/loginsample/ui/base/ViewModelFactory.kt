package com.fowels.loginsample.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fowels.loginsample.data.repository.AuthRepository
import com.fowels.loginsample.data.repository.BaseRepository
import com.fowels.loginsample.data.repository.UserRepository
import com.fowels.loginsample.ui.auth.AuthViewModel
import com.fowels.loginsample.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as UserRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found!")
        }
    }
}