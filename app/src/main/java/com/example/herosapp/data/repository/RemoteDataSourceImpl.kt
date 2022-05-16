package com.example.herosapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.herosapp.data.local.HeroDatabase
import com.example.herosapp.data.paging_source.HeroRemoteMediator
import com.example.herosapp.data.remote.HeroApi
import com.example.herosapp.domain.model.Hero
import com.example.herosapp.domain.repository.RemoteDataSource
import com.example.herosapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val heroApi: HeroApi,
    private val heroDatabase: HeroDatabase
): RemoteDataSource {

    private val heroDao = heroDatabase.heroDao()


    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = {heroDao.getAllHeroes()}
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                heroApi = heroApi,
                heroDatabase = heroDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}