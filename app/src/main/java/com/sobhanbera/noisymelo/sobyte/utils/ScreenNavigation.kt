package com.sobhanbera.noisymelo.sobyte.utils

import androidx.navigation.NavController
import com.sobhanbera.noisymelo.sobyte.model.ScreenParams

/**
 * This function is used to navigate to a screen
 *
 * @param navigationController: NavController - The NavController instance to navigate to the screen
 * @param screenParams: ScreenParams - The ScreenParams data
 * @return String - The screen route name
 */
fun navigateToScreen(navigationController: NavController, screenParams: ScreenParams): String {
	navigationController.navigate(screenParams.screenRouteName)

	return screenParams.screenRouteName
}