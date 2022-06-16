package com.example.daggertuto.ui.main.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggertuto.data.model.User
import com.example.daggertuto.data.repository.MainRepository
import com.example.daggertuto.utils.NetworkHelper
import com.example.daggertuto.utils.Resource
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
): ViewModel(){
    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users
    init {

        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch{
            _users.postValue(Resource.loading(null))
            if(networkHelper.isNetworkConnectedStatus()){
                mainRepository.getUsers().let {
                    if(it.isSuccessful){
                        _users.postValue(Resource.success(it.body()))
                    }else
                        _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }else
                _users.postValue(Resource.error("İnternet bağlantısı sağlanamadı", null))
        }
    }


}