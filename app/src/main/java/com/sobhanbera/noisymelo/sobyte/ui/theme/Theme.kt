package com.sobhanbera.noisymelo.sobyte.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

/**
 * color palette for dark theme of our application
 * @see [darkColors]
 * @see [SobyteTheme]
 */
private val DarkColorPalette = darkColors(
	primary = DarkPrimary,
	primaryVariant = DarkPrimaryVariant,
	secondary = DarkSecondary,
	secondaryVariant = DarkSecondaryVariant,
	background = DarkBackground,
	surface = DarkSurface,
	error = DarkError,
	onPrimary = DarkOnPrimary,
	onSecondary = DarkOnSecondary,
	onBackground = DarkOnBackground,
	onSurface = DarkOnSurface,
	onError = DarkOnError,
)

/**
 * theme of our application
 * @param darkTheme whether to use dark theme or not
 * @param content content to be displayed
 * @see [MaterialTheme]
 */
@Composable
fun SobyteTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	content: @Composable () -> Unit
) {
	val colors = DarkColorPalette

	CompositionLocalProvider(LocalGutters provides Gutters()) {
		MaterialTheme(
			colors = colors,
			typography = Typography,
			shapes = Shapes,
			content = content
		)
	}
}
