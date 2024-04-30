package com.example.connectionretrofit.network

import com.example.connectionretrofit.models.ImagenRandom
import com.example.connectionretrofit.models.ImagenesRaza
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("breeds/image/random") //Peticion get y definir url relativa
    suspend fun imagenAleatoria(): Response<ImagenRandom> //nombre de funcion para la peticion y tipo de objeto

    @GET("breed/{breed}/images") //dogs.ceo/api/breed/------/image
    suspend fun getImagesByBreed(@Path("breed") breed: String): Response<ImagenesRaza>
}