package com.example.connectionretrofit.network

import com.example.connectionretrofit.models.ImagenRandom
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("breeds/image/random") //Peticion get y definir url relativa
    suspend fun imagenAleatoria(): Response<ImagenRandom> //nombre de funcion para la peticion y tipo de objeto
}