package com.otp.wiseappassignment.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    private val originalRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val cocktailApiService: CocktailApiService by lazy {
        originalRetrofit.create(CocktailApiService::class.java)
    }
}
