package com.otp.wiseappassignment.ui.theme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otp.wiseappassignment.data.model.Cocktail
import com.otp.wiseappassignment.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(private val repository: CocktailRepository) :
    ViewModel() {
    private val _cocktailList = MutableLiveData<List<Cocktail>>()
    val cocktailList: LiveData<List<Cocktail>>
        get() = _cocktailList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun searchCocktail(query: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = repository.searchCocktail(query)
                if (response.drinks.isEmpty()) {
                    _cocktailList.value = emptyList()
                } else {
                    _cocktailList.value = response.drinks
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
