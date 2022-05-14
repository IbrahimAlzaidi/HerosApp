package com.example.herosapp.data.remote

import com.example.herosapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroApi {
    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1,
    ): ApiResponse


    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String,
    ): ApiResponse

}