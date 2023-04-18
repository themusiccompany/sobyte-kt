package com.sobhanbera.noisymelo.sobyte.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

// default colors for MaterialTheme
val DarkPrimary = Color(0xFF003785)
val DarkPrimaryVariant = Color(0xFF0F60B6)
val DarkSecondary = Color(0xFFEF1559)
val DarkSecondaryVariant = Color(0xFFEE7674)
val DarkBackground = Color(0xFF121212)
val DarkSurface = Color(0xFF21242b)
val DarkError = Color(0xFFFF5500)
val DarkOnPrimary = Color(0xFF003785)
val DarkOnSecondary = Color(0xFFEF1559)
val DarkOnBackground = Color(0xFF121212)
val DarkOnSurface = Color(0xFF21242b)
val DarkOnError = Color(0xFFFF5500)

// the extra colors for MaterialTheme
val Colors.extras: ExtraColors
	get() = object : ExtraColors {
		override val theme: Color
			get() = Color(0xFF000000)
		override val themeInverse: Color
			get() = Color(0xFFFFFFFF)
		override val surfaceLight: Color
			get() = Color(0xFF282B32)
		override val border: Color
			get() = Color(0xFF191919)
		override val surfaceBorder: Color
			get() = Color(0xFF191919)
		override val surfaceBorderLight: Color
			get() = Color(0xFF383B42)
		override val placeholder: Color
			get() = Color(0xFF383B42)
		override val text: Color
			get() = Color(0xFFEFEFEF)
		override val onSuccess: Color
			get() = Color(0xFF28A745)
		override val onWarning: Color
			get() = Color(0xFFFFC107)
		override val onDanger: Color
			get() = Color(0xFFDC3545)
	}
