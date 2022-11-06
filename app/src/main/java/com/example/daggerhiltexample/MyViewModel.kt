package com.example.daggerhiltexample

import android.util.Log
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
import kotlinx.coroutines.withContext
import javax.inject.Inject

fun log(string: String) {
    Log.d("MyViewModel", string)
}


@HiltViewModel
class MyViewModel @Inject constructor(
    private val repositoryInterface: RepositoryInterface
) : ViewModel() {
    val maxItems = 21
    var isLoading: MutableState<Boolean> = mutableStateOf(false)
    var _dataFetchCounter = mutableStateOf(1)
    var dataFetchCounter: State<Int> = _dataFetchCounter
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
    private var _listData = mutableListOf<ApiDetailResponse>()
    var listData: List<ApiDetailResponse> = _listData


    init {
        try {
            getPokemonList()
        }catch (e:Exception){
            println("Log : Connection Exception")
        }
    }


    private fun getPokemonList() {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            for (index: Int in 1..maxItems) {
                println("log : Calling api with index $index")
                _data.value =
                    withContext(Dispatchers.Default) {
                        try {
                            repositoryInterface.netWorkGetRequest(index.toString()).body()!!
                        }
                        catch (e: Exception){
                            //TODO Display default data if request failed
                            println("Log : Connection Exception --> $e")
                            ApiDetailResponse(id = 0,name=e.toString(), types = emptyList(), sprites = mapOf())
                        }

                    }

                _listData.add(_data.value)
                _dataFetchCounter.value = index
                println("log : _dataFetchCounter updated $_dataFetchCounter")

                println("log : Adding result to list --> ${_listData}")
                println("log : After adding size is --> ${_listData.size}")
                println("log : ending deffered")
            }
            isLoading.value = false

        }
    }





}


