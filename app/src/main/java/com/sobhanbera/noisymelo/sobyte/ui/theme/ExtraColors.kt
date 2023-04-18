package com.sobhanbera.noisymelo.sobyte.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material.Colors

/**
 * this interface is a model that contains data about extra
 * colors needed in the UI
 * this will be accessed using MaterialTheme.colors.extras
 * @see [Colors.extras]
 */
interface ExtraColors {
	val transparent: Color
	val theme: Color
	val themeInverse: Color
	val surfaceLight: Color
	val border: Color
	val surfaceBorder: Color
	val surfaceBorderLight: Color
	val placeholder: Color
	val text: Color
	val onSuccess: Color
	val onWarning: Color
	val onDanger: Color
}