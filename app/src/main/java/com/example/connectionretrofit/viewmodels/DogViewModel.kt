package com.example.connectionretrofit.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connectionretrofit.network.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DogViewModel:ViewModel() {

    var urlImage by mutableStateOf("")
        private set

    private val _images = MutableStateFlow<   List<String>  > (emptyList())
    var images = _images.asStateFlow()

    init{
        fetchData()
    }
    fun fetchData(){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                urlImage = API().getImagenAleatoria()
            }
        }
    }

    fun fetchImagesByBreed(raza:String){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                val response = API().getListImages(raza)
                _images.value = response ?: emptyList()
                images = _images
            }
        }
    }
}