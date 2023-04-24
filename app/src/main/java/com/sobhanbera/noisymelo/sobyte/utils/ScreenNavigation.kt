package com.sobhanbera.noisymelo.sobyte.utils

import android.content.res.Resources
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

/**
 * This function is used to get the status bar height
 *
 * @return Int - The status bar height
 */
fun getStatusBarHeight(): Int {
	val resourceId = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android")
	var statusBarHeight = if (resourceId > 0) Resources.getSystem().getDimensionPixelSize(resourceId) else 0
	// converting the px height to dp
	statusBarHeight = (statusBarHeight / Resources.getSystem().displayMetrics.density).toInt()

	return statusBarHeight
}

/**
 * This function is used to add the status bar height to the given height
 *
 * @param extraHeight: Int - The height to which the status bar height is to be added
 * @return Int - The height with the status bar height added
 */
fun addToStatusBarHeight(extraHeight: Int): Int {
	return getStatusBarHeight() + extraHeight
}