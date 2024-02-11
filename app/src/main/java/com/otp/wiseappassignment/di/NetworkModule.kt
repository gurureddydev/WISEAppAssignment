package com.otp.wiseappassignment.di

import com.otp.wiseappassignment.data.api.CocktailApiService
import com.otp.wiseappassignment.data.api.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCocktailApiService(): CocktailApiService {
        return RetrofitInstance.cocktailApiService
    }
}


