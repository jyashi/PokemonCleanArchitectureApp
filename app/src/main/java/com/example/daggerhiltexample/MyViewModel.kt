package com.example.daggerhiltexample

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltexample.model.ApiDetailResponse
import com.example.daggerhiltexample.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

fun log(string: String){
    Log.d("MyViewModel",string)
}

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repositoryInterface: RepositoryInterface,
    private val baseUrl: String
) : ViewModel() {
    var isLoading: MutableState<Boolean> = mutableStateOf(false)
    private val _data =
        mutableStateOf(
            ApiDetailResponse(
                id = 1,
                name = "name",
                types = emptyList(),
                sprites = mutableMapOf()
            )
        )
    var data: MutableState<ApiDetailResponse> = _data

    private var _listData = mutableListOf< MutableState<ApiDetailResponse>>()
    var listData: MutableList<MutableState<ApiDetailResponse>> = _listData


    init {
        viewModelScope.launch { getPokemonList() }
    }

   private suspend fun getPokemonList() {
       log("Entered list fn")
        for(index: Int in 1..12){

            getPokemonDetails(index.toString())
            _listData.add(_data)
        }
log("Exiting")
    }



     suspend fun getPokemonDetails(id: String) {
    isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {

            _data.value = repositoryInterface.netWorkGetRequest(id).body()!!
            log("_Data ---> ${_data.value}")


        }



    }


}


