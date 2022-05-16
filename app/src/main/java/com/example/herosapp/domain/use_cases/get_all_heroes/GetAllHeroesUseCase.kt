package com.example.herosapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.example.herosapp.data.repository.Repository
import com.example.herosapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>>{
        return repository.getAllHeroes()
    }
}