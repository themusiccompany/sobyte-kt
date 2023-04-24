package com.sobhanbera.noisymelo.sobyte.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sobhanbera.noisymelo.sobyte.model.AppLogLevels
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras

@Composable
fun AppSnackbarHost(
	snackbarHostState: SnackbarHostState = SnackbarHostState(),
) {
	SnackbarHost(
		hostState = snackbarHostState,
		modifier = Modifier.offset(y = (-55).dp),
	) {
		/**
		 * this variable hold the icon and color data to show in the UI
		 * iconAndColor.first         - icon
		 * iconAndColor.second.first  - background color
		 * iconAndColor.second.second - text color
		 */
		val iconAndColor = when(it.actionLabel) {
			AppLogLevels.SUCCESS.name -> Icons.Outlined.Done to (MaterialTheme.colors.surface to MaterialTheme.colors.extras.onSuccess)
			AppLogLevels.INFO.name -> Icons.Outlined.Info to (MaterialTheme.colors.surface to MaterialTheme.colors.extras.text)
			AppLogLevels.WARN.name -> Icons.Outlined.Warning to (MaterialTheme.colors.surface to MaterialTheme.colors.extras.onWarning)
			AppLogLevels.ERROR.name -> Icons.Outlined.Report to (MaterialTheme.colors.surface to MaterialTheme.colors.extras.onDanger)
			else -> Icons.Outlined.Info to (MaterialTheme.colors.surface to MaterialTheme.colors.extras.text)
		}

		// ui of the custom app snackbar
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp)
				.background(
					color = iconAndColor.second.first,
					shape = RoundedCornerShape(CornerSize(8.dp))
				)
				.clickable {
					it.dismiss()
				},
		) {
			Row(
				horizontalArrangement = Arrangement.Start,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
					.height(50.dp)
					.padding(5.dp),
			) {
				Spacer(modifier = Modifier.width(10.dp))

				// icon based on the type of label passed
				Icon(
					iconAndColor.first,
					contentDescription = "",
					modifier = Modifier,
					tint = iconAndColor.second.second
				)

				Spacer(modifier = Modifier.width(10.dp))

				// the actual prompt to show
				Text(
					text = it.message,
					style = TextStyle(
						fontWeight = FontWeight.Medium,
					),
					color = iconAndColor.second.second,
					maxLines = 1,
				)

				Spacer(modifier = Modifier.width(10.dp))
			}
		}
	}
}