package com.example.herosapp.domain.use_cases.save_onboarding

import com.example.herosapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(completed: Boolean){
        repository.saveOnBoardingState(completed = completed)
    }

}