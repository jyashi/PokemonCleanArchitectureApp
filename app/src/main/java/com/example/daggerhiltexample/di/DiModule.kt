package com.example.daggerhiltexample.di

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.daggerhiltexample.MyViewModel
import com.example.daggerhiltexample.repository.RepositoryImpl
import com.example.daggerhiltexample.repository.RepositoryInterface
import com.example.daggerhiltexample.data.network.ApiInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    private const val base_url: String = "https://pokeapi.co/api/v2/pokemon/"

    @Provides
    @Singleton
    fun injectApi(): ApiInterface {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(base_url)
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun injectRepository(apiInterface: ApiInterface, appContext: Application): RepositoryInterface {
        return RepositoryImpl(injectApi(), appContext)
    }


//    @Provides
//    @Singleton
//    fun injectViewModel(): HiltViewModel{
//        return HiltViewModel()
//    }

    @Provides
    @Singleton
    fun injectBaseUrl(): String = base_url


}