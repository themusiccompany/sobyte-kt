package com.sobhanbera.noisymelo.sobyte.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sobhanbera.noisymelo.sobyte.R
import com.sobhanbera.noisymelo.sobyte.configs.DEFAULT_ICON_SIZE
import com.sobhanbera.noisymelo.sobyte.configs.DEFAULT_LOGO_RENDER_WIDTH
import com.sobhanbera.noisymelo.sobyte.configs.DEVICE_STATUS_BAR_HEIGHT
import com.sobhanbera.noisymelo.sobyte.ui.theme.gutters

@Composable
fun AppLogoHeader() {
	TODO("This component is not implemented yet.")
	
	Row(
		horizontalArrangement = Arrangement.SpaceBetween,
		modifier = Modifier
			.fillMaxWidth()
			.padding(0.dp, DEVICE_STATUS_BAR_HEIGHT.dp, 0.dp, 0.dp)
	) {
		Row(
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier
				.fillMaxWidth()
				.padding(MaterialTheme.gutters.regular, DEVICE_STATUS_BAR_HEIGHT.dp, 0.dp, 0.dp)
		) {
			Image(
				painter = painterResource(id = R.drawable.logo_small),
				contentDescription = "",
				modifier = Modifier
					.size(DEFAULT_LOGO_RENDER_WIDTH.dp)
			)

			Icon(
				Icons.Rounded.Search,
				contentDescription = "",
				modifier = Modifier.size(DEFAULT_ICON_SIZE.dp)
			)
		}
	}
}

