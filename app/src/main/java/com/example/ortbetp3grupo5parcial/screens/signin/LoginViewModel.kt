package com.example.ortbetp3grupo5parcial.screens.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ortbetp3grupo5parcial.models.LoginRequest
import com.example.ortbetp3grupo5parcial.models.LoginResponse
import com.example.ortbetp3grupo5parcial.network.RetrofitClient
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val loginResponse = MutableLiveData<LoginResponse>()
    val loginError = MutableLiveData<String>()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.authService.login(LoginRequest(username, password))
                loginResponse.postValue(response)
            } catch (e: Exception) {
                loginError.postValue("Error: ${e.message}")
            }
        }
    }
}