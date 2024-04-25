package com.example.connectionretrofit.network

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
//Configurar retrofit , creamos el objeto retrofit
private val URL_BASE = "https://dog.ceo/api/"
    fun getRetrofitService(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: ApiInterface = retrofit.create(ApiInterface::class.java)
        return service
    }
}


class API {
    //donde recopilaremos los datos y haremos validaciones pertinentes
    private val service = RetrofitHelper.getRetrofitService()
    //instanciar el servicio retrofit de nuestro obejtos anteriores

    //funcioens
    suspend fun getImagenAleatoria():String {
        val msg:String
        val response = service.imagenAleatoria()
        /*obtenemos la respuesta y aplicamos la logica de que deseamos hacer con los campos*/
        if(response.body()?.status.equals("success")){
            msg = response.body()?.message ?: "" }
        else{ msg = "NO fue exitoso" }
        Log.d("API_PRUEBA", "status es " + response.body()?.status)
        Log.d("API_PRUEBA ", "message es " + response.body()?.message)
        return msg
    }
}