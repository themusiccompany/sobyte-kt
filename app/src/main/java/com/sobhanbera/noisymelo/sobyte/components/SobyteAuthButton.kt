package com.sobhanbera.noisymelo.sobyte.components

import android.text.style.ClickableSpan
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sobhanbera.noisymelo.sobyte.funextension.scaleOnClick

@Composable
fun SobyteAuthButton(
	text: String,
	onClick: () -> Unit,
	gradientAngle: Float = 184f,
	gradientColor: List<Color> = listOf(),
	useSingleColor: Boolean = false,
	modifier: Modifier = Modifier,
	textStyle: TextStyle = MaterialTheme.typography.h6,
	cornerRadius: Dp = 500.dp,
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
			.then(modifier),
		gradientAngle = gradientAngle,
		cornerRadius = cornerRadius,
		parentModifier = Modifier
			.scaleOnClick(
				onClick = onClick,
				cornerRadius = cornerRadius
			), // to make it scale when clicked
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
