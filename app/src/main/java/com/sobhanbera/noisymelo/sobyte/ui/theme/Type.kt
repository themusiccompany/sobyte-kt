package com.sobhanbera.noisymelo.sobyte.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.sobhanbera.noisymelo.sobyte.R

val ProductSansFont = FontFamily(
	Font(R.font.product_sans),
	Font(R.font.product_sans_italic, FontWeight.Normal, FontStyle.Italic),
	Font(R.font.product_sans_bold, FontWeight.Bold),
	Font(R.font.product_sans_bold_talic, FontWeight.Bold, FontStyle.Italic),
)

val CircularFont = FontFamily(
	Font(R.font.circular_regular, FontWeight.Normal),
	Font(R.font.circular_medium, FontWeight.Medium),
	Font(R.font.circular_light, FontWeight.Light),
	Font(R.font.circular_bold, FontWeight.Bold),
	Font(R.font.circular_black, FontWeight.Black),
)

// Set of Material typography styles to start with
val Typography = Typography(
	// setting the default font to product sans
	defaultFontFamily = CircularFont,

	h1 = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Bold,
		fontSize = 55.sp
	),
	body1 = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp
	),
	button = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Medium,
		fontSize = 18.sp,
		color = Color.White,
		textAlign = TextAlign.Center,
	),
)

// here are few extra typography that are not provided by default
// in the MaterialTheme
val Typography.extras: ExtraTypography
	get() = object : ExtraTypography {
		override val err: TextStyle
			get() = TextStyle(
				fontFamily = FontFamily.Default,
				fontWeight = FontWeight.Bold,
				fontSize = 14.sp,
			)
	}