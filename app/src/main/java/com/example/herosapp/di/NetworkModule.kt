package com.example.herosapp.di

import androidx.paging.ExperimentalPagingApi
import com.example.herosapp.data.local.HeroDatabase
import com.example.herosapp.data.remote.HeroApi
import com.example.herosapp.data.repository.RemoteDataSourceImpl
import com.example.herosapp.domain.repository.RemoteDataSource
import com.example.herosapp.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.MINUTES)
            .connectTimeout(15, TimeUnit.MINUTES)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideHeroesApi(retrofit: Retrofit): HeroApi {
        return retrofit.create(HeroApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRemoteDataSource(
        heroApi: HeroApi,
        heroDatabase: HeroDatabase,
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            heroApi = heroApi,
            heroDatabase = heroDatabase
        )
    }


}