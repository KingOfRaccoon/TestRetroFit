package com.kingofraccoon.testretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClient {
    var retrofit: Retrofit? = null
        get() {
        if (field == null){
            field = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return field
        }
        else
            return field
    }

    fun instanse(): ApiPlaceHolder? {
        return retrofit?.create(ApiPlaceHolder:: class.java)
    }

    var posts = mutableListOf<Post>()
}