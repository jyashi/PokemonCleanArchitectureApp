package com.example.daggerhiltexample.di

import android.app.Application
import com.example.daggerhiltexample.repository.RepositoryImpl
import com.example.daggerhiltexample.repository.RepositoryInterface
import com.example.daggerhiltexample.data.network.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    private const val base_url: String = "https://pokeapi.co/"
    @Provides
    @Singleton
    fun injectApi(): ApiInterface {
        return Retrofit.Builder().baseUrl(base_url).build().create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun injectRepository(apiInterface: ApiInterface, appContext: Application): RepositoryInterface {
        return RepositoryImpl(injectApi(), appContext)
    }

    @Provides
    @Singleton
    fun provideString(): String = "This is test string from DI"


}