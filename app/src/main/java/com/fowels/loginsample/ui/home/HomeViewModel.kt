package com.fowels.loginsample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fowels.loginsample.data.network.Resource
import com.fowels.loginsample.data.repository.UserRepository
import com.fowels.loginsample.data.responses.LoginResponse
import com.fowels.loginsample.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
        private val repository: UserRepository
) : BaseViewModel(repository) {

    private val _user: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val user: LiveData<Resource<LoginResponse>>
        get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = Resource.Loading
        _user.value = repository.getUser()
    }
}