package com.example.herosapp.navigation

import com.example.herosapp.util.Constants.DETAILS_ARGUMENT_KEY

sealed class Screen(val route: String){
    object Splash: Screen("splash_screen")
    object Welcome: Screen("welcome_screen")
    object Home: Screen("home_screen")
    object Details: Screen("details_screen/{$DETAILS_ARGUMENT_KEY}"){
        fun passHeroId(heroId: Int): String {
            return "details_screen/$heroId"
        }
    }
    object Search: Screen("search_screen")
}
