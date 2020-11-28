package com.kingofraccoon.testretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiPlaceHolder {
    @GET("posts")
    fun getPosts(): Call<MutableList<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Call<Post>
}