package com.sobhanbera.noisymelo.sobyte.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sobhanbera.noisymelo.sobyte.configs.DEVICE_STATUS_BAR_HEIGHT

@Composable
fun StatusBarSpacer(
	height: Dp = DEVICE_STATUS_BAR_HEIGHT.dp,
) {
	// empty container with some height
	Box(
		modifier = Modifier
			.height(height)
			.fillMaxWidth()
	)
}