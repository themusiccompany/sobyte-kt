package com.sobhanbera.noisymelo.sobyte.model

import androidx.compose.ui.graphics.Color
import com.sobhanbera.noisymelo.sobyte.ui.theme.DarkBackground

/**
 * types of outputs and logs available throughout the app
 */
enum class AppLogLevels {
	SUCCESS,
	INFO,
	WARN,
	ERROR,
}

/**
 * types of outputs and logs available throughout the app
 * dominantColor, lightVibrantColor, darkVibrantColor, lightMutedColor, darkMutedColor
 */
interface ColorPalette {
	val dominantColor: Color
	val lightVibrantColor: Color
	val darkVibrantColor: Color
	val lightMutedColor: Color
	val darkMutedColor: Color
//	val swatches: List<Color>
}

/**
 * default color palette
 * dominantColor, lightVibrantColor, darkVibrantColor, lightMutedColor, darkMutedColor
 */
val DefaultColorPalette = object: ColorPalette {
	override val dominantColor: Color = DarkBackground
	override val lightVibrantColor: Color = DarkBackground
	override val darkVibrantColor: Color = DarkBackground
	override val lightMutedColor: Color = DarkBackground
	override val darkMutedColor: Color = DarkBackground
//	override val swatches: List<Color> = listOf(DarkBackground, DarkBackground)
}