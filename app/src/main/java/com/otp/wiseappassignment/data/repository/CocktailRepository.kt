package com.otp.wiseappassignment.data.repository

import com.otp.wiseappassignment.data.api.CocktailApiService
import com.otp.wiseappassignment.data.model.CocktailResponse

class CocktailRepository(private val apiService: CocktailApiService) {

    suspend fun searchCocktail(query: String): CocktailResponse {
        return apiService.searchCocktail(query)
    }
}

