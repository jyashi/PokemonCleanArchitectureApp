package com.example.daggerhiltexample

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
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
class MyViewModel @Inject constructor(
    private val repositoryInterface: RepositoryInterface,
    private val provideString: String
) : ViewModel() {
    private val _data =
        mutableStateOf(
            ApiDetailResponse(
                id = 0,
                name = "name",
                types = emptyList(),
                sprites = mutableMapOf()
            )
        )
    var data: MutableState<ApiDetailResponse> = _data

    private val _listData = emptyList<MutableState<ApiDetailResponse>>()
    var listData: List<MutableState<ApiDetailResponse>> = _listData


    init {
        getPokemonDetails("1")
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            for(index: Int in 0..12){
                println("Generating list $index")
                val listResult = repositoryInterface.netWorkGetRequest(index.toString())
            }

        }
    }

    fun testString() = provideString

    fun getPokemonDetails(id: String) {

        viewModelScope.launch(Dispatchers.IO) {
            _data.value = repositoryInterface.netWorkGetRequest(id).body()!!
            println(
                "From view model response --> ${data.value.sprites}"
            )

            _data.value = repositoryInterface.netWorkGetRequest(id).body()!!
        }
    }

}