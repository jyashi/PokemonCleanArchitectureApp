package com.example.daggerhiltexample

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltexample.model.ApiDetailResponse
import com.example.daggerhiltexample.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel@Inject constructor(private val repositoryInterface: RepositoryInterface, private val provideString: String): ViewModel() {
    private val _pokemonDetails = mutableStateOf(ApiDetailResponse(id = 0, name = "name", types = emptyList()))
    fun testString() = provideString

    fun getPokemonDetails(id: String) {

        viewModelScope.launch(Dispatchers.IO) {
            println("From view model response --> ${repositoryInterface.netWorkGetRequest(id).body()} ")
            _pokemonDetails.value = repositoryInterface.netWorkGetRequest(id).body()!!
        }
    }

}