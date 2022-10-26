package com.example.daggerhiltexample

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltexample.model.ApiDetailResponse
import com.example.daggerhiltexample.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

fun log(string: String) {
    Log.d("MyViewModel", string)
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
    private var _listData = mutableListOf<ApiDetailResponse>()
    var listData: List<ApiDetailResponse> = _listData


    init {
        getPokemonList()
    }



    fun getPokemonList() {
        isLoading.value = true




            viewModelScope.launch(Dispatchers.IO) {
                for (index: Int in 1..12) {
                    println("log : Calling api with index $index")
                    _data.value = async {repositoryInterface.netWorkGetRequest(index.toString()).body()!!}.await()
//

                    println("log : Deffered result received")
                    _listData.add(_data.value)
                    println("log : Adding result to list --> ${_listData}")
                    println("log : After adding size is --> ${_listData.size}")


                    println("log : ending deffered")
                }
                isLoading.value = false

            }
//        if (listData.size > 10) {
//            log("Size ${listData.size}")
//
//        }
    }


     fun getPokemonDetails(id: String) {

        viewModelScope.launch(Dispatchers.IO)  {
            _data.value = withContext(Dispatchers.Default) {
                repositoryInterface.netWorkGetRequest(id).body()!!
            }

            _listData.add(_data.value)
            isLoading.value = false

        }


    }


}


