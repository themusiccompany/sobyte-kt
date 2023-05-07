package com.sobhanbera.noisymelo.sobyte.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import com.sobhanbera.noisymelo.sobyte.configs.DEVICE_STATUS_BAR_HEIGHT

data class Gutters (
	val extraTiny: Int = 2,
	val tiny: Int = 5,
	val small: Int = 10,
	val regular: Int = 15,
	val medium: Int = 20,
	val large: Int = 26,
	val extraLarge: Int = 32,
	val massive: Int = 5 * 4 * 5, // 100
	val huge: Int = 3 * 5 * 5 * 2, // 150

	val statusBarHeight: Int = DEVICE_STATUS_BAR_HEIGHT, // this special key contains the value of status bar's height
)

val LocalGutters = compositionLocalOf { Gutters() }

val MaterialTheme.gutters: Gutters
	@Composable
	@ReadOnlyComposable
	get() = LocalGutters.current
