package com.example.herosapp.domain.use_cases.get_selected_hero

import com.example.herosapp.data.repository.Repository
import com.example.herosapp.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository,
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}