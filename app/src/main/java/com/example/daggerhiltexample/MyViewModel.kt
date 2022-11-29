package com.example.daggerhiltexample

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltexample.domain.model.PokemonDataObject
import com.example.daggerhiltexample.data.repository.database
import com.example.daggerhiltexample.domain.model.ApiDetailResponse
import com.example.daggerhiltexample.domain.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

private val _tag = "MyViewModel"
fun log(string: String) {
    Log.d(_tag, string)
}


@HiltViewModel
class MyViewModel @Inject constructor(
    private val repositoryInterface: RepositoryInterface,
    private val database: database
) : ViewModel() {

    val maxItems = 51
    var isLoading: MutableState<Boolean> = mutableStateOf(false)
    var _dataFetchCounter = mutableStateOf(1)
    var dataFetchCounter: State<Int> = _dataFetchCounter
    private val _data = mutableStateOf(
        ApiDetailResponse(
            id = 1, name = "name", types = emptyList(), sprites = mutableMapOf()
        )
    )
    var data: MutableState<ApiDetailResponse> = _data
    private var _listData = mutableListOf<ApiDetailResponse>()
    var listData: List<ApiDetailResponse> = _listData
    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> log("Exception Captured") }


    init {
//        viewModelScope.launch {
//            if(database.dao.getListData().isEmpty()){
//
//            }
//        }

        try {
            getPokemonListFromApi()

        } catch (e: Exception) {

            println("Log : Connection Exception")
        }

    }


    private fun getPokemonListFromApi() {
        isLoading.value = true
        viewModelScope.launch(exceptionHandler) {
            for (index: Int in 1..maxItems) {
                _data.value = withContext(exceptionHandler) {

                    try {
                        repositoryInterface.netWorkGetRequest(index.toString()).body()!!
                    } catch (e: Exception) {
                        //TODO Display error dialog if request failed
                        ApiDetailResponse(
                            id = 0, name = e.toString(), types = emptyList(), sprites = mapOf()
                        )
                    }

                }

                _listData.add(_data.value)
                _dataFetchCounter.value = index
            }
            savePokemonListInDatabase(listData)
            isLoading.value = false

        }
    }

    private suspend fun savePokemonListInDatabase(data: List<ApiDetailResponse>) {
       data.forEach {
           database.dao.insertData(
               PokemonDataObject(
               id = it.id,
               name = it.name,
               type = it.types.toString(),
               sprite = it.sprites.toString()
           )
           )
       }


    }


}


