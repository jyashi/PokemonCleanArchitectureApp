package com.example.daggerhiltexample.di

import com.example.daggerhiltexample.data.domain.repository.RepositoryImpl
import com.example.daggerhiltexample.data.domain.repository.RepositoryInterface
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
    private const val url: String = ""
    @Provides
    @Singleton
    fun injectApi(): ApiInterface {
        return Retrofit.Builder().baseUrl(url).build().create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun injectRepository(): RepositoryInterface {
        return RepositoryImpl(injectApi())
    }
}