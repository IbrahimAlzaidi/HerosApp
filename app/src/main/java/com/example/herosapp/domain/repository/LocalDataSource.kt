package com.example.herosapp.domain.repository

import com.example.herosapp.domain.model.Hero

interface LocalDataSource {

    suspend fun getSelectedHero(heroId: Int) : Hero

}