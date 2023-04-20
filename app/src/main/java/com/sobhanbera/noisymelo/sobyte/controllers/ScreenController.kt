package com.sobhanbera.noisymelo.sobyte.controllers

import androidx.navigation.NavController
import com.sobhanbera.noisymelo.sobyte.model.ScreenParams

class ScreenController constructor(
	private val navController: NavController
) {
	fun navigateTo(screenParam: ScreenParams) {
		navController.navigate(screenParam.screenRouteName)
	}
}
