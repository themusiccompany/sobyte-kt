package com.sobhanbera.noisymelo.sobyte.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

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
 * color palette for light theme of our application
 * @see [lightColors]
 * @see [SobyteTheme]
 */
@Deprecated(
	"We are only providing dark theme as of initial production build...",
	level = DeprecationLevel.WARNING,
	replaceWith = ReplaceWith(
		"DarkColorPalette",
		"com.sobhanbera.noisymelo.sobyte.ui.theme.DarkColorPalette",
	)
)
private val LightColorPalette = lightColors(
	primary = LightPrimary,
	primaryVariant = LightPrimaryVariant,
	secondary = LightSecondary,
	secondaryVariant = LightSecondaryVariant,
	background = LightBackground,
	surface = LightSurface,
	error = LightError,
	onPrimary = LightOnPrimary,
	onSecondary = LightOnSecondary,
	onBackground = LightOnBackground,
	onSurface = LightOnSurface,
	onError = LightOnError,
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
//	val colors = if (darkTheme) DarkColorPalette else LightColorPalette
	val colors = DarkColorPalette

	MaterialTheme(
		colors = colors,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}
