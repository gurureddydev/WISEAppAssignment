package com.otp.wiseappassignment.data.api

import com.otp.wiseappassignment.data.model.CocktailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CocktailApiService {
    @GET("search.php")
    suspend fun searchCocktail(@Query("s") query: String): CocktailResponse
}
