package com.otp.wiseappassignment.di

import com.otp.wiseappassignment.data.api.CocktailApiService
import com.otp.wiseappassignment.data.repository.CocktailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideCocktailRepository(apiService: CocktailApiService): CocktailRepository {
        return CocktailRepository(apiService)
    }
}