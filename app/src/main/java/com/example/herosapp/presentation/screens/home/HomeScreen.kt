package com.example.herosapp.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        topBar = { HomeTopBar {  }}
    ) {}

}