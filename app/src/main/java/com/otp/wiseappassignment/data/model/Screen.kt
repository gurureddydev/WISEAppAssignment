package com.otp.wiseappassignment.data.model

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details")

}