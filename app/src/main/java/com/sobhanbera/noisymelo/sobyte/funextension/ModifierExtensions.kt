package com.sobhanbera.noisymelo.sobyte.funextension

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.math.*

/**
 * This function is used to create a gradient background
 * by extending the Modifier class
 * and adding a rectangle with a linear gradient brush
 *
 * @param colors the list of colors to be used in the gradient
 * @param angle the angle of the gradient
 * @return the modifier with the gradient background
 */
fun Modifier.gradientBackground(
	colors: List<Color>,
	angle: Float
) = this.then(
	Modifier.drawBehind {
		// Get the center of the canvas
		val angleRad = angle / 180f * PI
		val x = cos(angleRad).toFloat() //Fractional x
		val y = sin(angleRad).toFloat() //Fractional y

		// Get the radius of the gradient
		val radius = sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
		// Get the center of the canvas
		val offset = center + Offset(x * radius, y * radius)

		// Get the exact offset
		val exactOffset = Offset(
			x = min(offset.x.coerceAtLeast(0f), size.width),
			y = size.height - min(offset.y.coerceAtLeast(0f), size.height)
		)

		// Draw the rectangle with the gradient
		drawRect(
			brush = Brush.linearGradient(
				colors = colors,
				start = Offset(size.width, size.height) - exactOffset,
				end = exactOffset
			),
			size = size
		)
	}
)