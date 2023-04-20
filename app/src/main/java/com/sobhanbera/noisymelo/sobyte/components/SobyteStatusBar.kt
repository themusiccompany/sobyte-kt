package com.sobhanbera.noisymelo.sobyte.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * this is the status bar component
 * this will be used to set the status bar color
 * @param color the color of the status bar
 */
@Composable
fun SobyteStatusBar(
	color: Color
) {
	// will have to shift this to the root of the app
	// or multiple rememberSystemUiController() will be called "!?not sure yet btw"
	val systemUiController = rememberSystemUiController()

	SideEffect {
		// changing the status bar color
		systemUiController.setSystemBarsColor(
			color = color,
		)
	}
}