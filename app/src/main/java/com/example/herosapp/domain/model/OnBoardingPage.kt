package com.example.herosapp.domain.model

import androidx.annotation.DrawableRes
import com.example.herosapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
){
    object First: OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greetings",
        description = R.string.greetings_on_board.toString()
    )
    object Second: OnBoardingPage(
        image = R.drawable.explore,
        title = "Explore",
        description = R.string.explore_on_board.toString()
    )
    object Third: OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        description = R.string.power_on_board.toString()
    )
}
