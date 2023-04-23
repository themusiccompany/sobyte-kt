package com.sobhanbera.noisymelo.sobyte.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AlternateEmail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SobyteAuthButton(
	text: String,
	onClick: () -> Unit,
	gradient: Boolean = false,
	gradientAngle: Float = 184f,
	gradientColor: List<Color> = listOf(),
	useSingleColor: Boolean = false,
	modifier: Modifier = Modifier,
	textStyle: TextStyle = MaterialTheme.typography.button,
	rightIcon: @Composable () -> Unit = {},
	leftIcon: @Composable () -> Unit = {},
) {
	SobyteLinearGradient(
		colors = if (useSingleColor) {
			listOf(MaterialTheme.colors.primary, MaterialTheme.colors.primary)
		} else {
			gradientColor.ifEmpty {
				listOf(MaterialTheme.colors.primary, MaterialTheme.colors.secondary)
			}
		},
		useSingleColor = useSingleColor,
		modifier = Modifier
			.fillMaxWidth(1f)
			.height(52.dp)
			.clickable {
				onClick()
			}
			.then(modifier),
		gradientAngle = gradientAngle,
		cornerRadius = 1000.dp,
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth(1f)
				.height(52.dp)
				.padding(horizontal = 20.dp),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically,
		) {
			Box(
				modifier = Modifier
					.padding(end = 15.dp)
			) {
				leftIcon()
			}

			Text(
				text = text,
				style = textStyle,
			)

			Box(
				modifier = Modifier
					.padding(start = 15.dp)
			) {
				rightIcon()
			}
		}
	}
}
