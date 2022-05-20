package com.example.herosapp.data.repository

import com.example.herosapp.data.local.HeroDatabase
import com.example.herosapp.domain.model.Hero
import com.example.herosapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    heroDatabase: HeroDatabase,
) : LocalDataSource {

    private val heroDao = heroDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}