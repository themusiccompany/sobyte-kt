package com.sobhanbera.noisymelo.sobyte.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sobhanbera.noisymelo.sobyte.configs.SobyteErrorCodes
import com.sobhanbera.noisymelo.sobyte.errorboundary.ErrorBoundary
import com.sobhanbera.noisymelo.sobyte.funextension.gradientBackground
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras

@Composable
fun SobyteLinearGradient(
	parentModifier: Modifier = Modifier,
	modifier: Modifier = Modifier,
	colors: List<Color> = MaterialTheme.colors.extras.primaryGradients,
	useSingleColor: Boolean = false,
	gradientAngle: Float = 315f,
	cornerRadius: Dp = 0.dp,
	content: @Composable () -> Unit,
) {
	/**
	 * since there must be at least 2 colors if provided through the colors parameter
	 * if not throw an exception
 	 */
	if (colors.isNotEmpty() && colors.size < 2) {
		return ErrorBoundary(
			error = SobyteErrorCodes.ILLEGAL_ARGUMENT_EXCEPTION,
			extraMessage = "colors parameter must have at least 2 colors",
		)
	}

	// box is just for border radius & nothing much
	Box(
		modifier = Modifier
			.clip(shape = RoundedCornerShape(cornerRadius))
			.then(parentModifier),
	) {
		Surface(
			color = MaterialTheme.colors.extras.transparent,
			contentColor = MaterialTheme.colors.extras.text,
			modifier = Modifier
				.gradientBackground(
					if (useSingleColor) {
						if (colors.isNotEmpty() && colors.size > 1) {
							listOf(colors[0], colors[0])
						} else {
							listOf(MaterialTheme.colors.primary, MaterialTheme.colors.primary)
						}
					} else {
						colors
					},
					angle = gradientAngle,
				)
				.then(modifier),
			content = content,
		)
	}
}
