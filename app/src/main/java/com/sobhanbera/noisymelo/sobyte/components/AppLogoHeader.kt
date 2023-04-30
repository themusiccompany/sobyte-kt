package com.sobhanbera.noisymelo.sobyte.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mikepenz.iconics.typeface.library.ionicons.Ionicons
import com.mikepenz.iconics.typeface.library.octicons.Octicons
import com.sobhanbera.noisymelo.sobyte.configs.*
import com.sobhanbera.noisymelo.sobyte.funextension.scaleOnClick
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras
import com.sobhanbera.noisymelo.sobyte.ui.theme.gutters

@Composable
fun AppLogoHeader(
	onClickSearch: () -> Unit = {},
) {
	Row(
		horizontalArrangement = Arrangement.Center,
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier
			.fillMaxWidth()
	) {
		Row(
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier
				.width(TRACK_ARTWORK_WIDTH_LARGE.dp)
				.padding(top = MaterialTheme.gutters.regular.dp)
		) {
			// app logo as small icon
			Box(
				modifier = Modifier
					.padding(horizontal = MaterialTheme.gutters.regular.dp)
					.scaleOnClick {}
			) {
				Image(
					painter = painterResource(id = DEFAULT_LOGO_RESOURCE_ID),
					contentDescription = "",
					modifier = Modifier
						.requiredWidth(DEFAULT_LOGO_RENDER_WIDTH.dp)
						.requiredHeight(DEFAULT_LOGO_RENDER_HEIGHT.dp)
				)
			}

			// search icon to navigation to search screen
			Box(modifier = Modifier
				.padding(MaterialTheme.gutters.tiny.dp)
				.padding(end = (MaterialTheme.gutters.tiny * 2).dp)
				.scaleOnClick {
					onClickSearch()
				}
			) {
				SobyteIcon(Octicons.Icon.oct_search)
			}
		}
	}
}

@Preview(showBackground = true, backgroundColor = 0xFF151515)
@Composable
fun AppLogoHeaderPreview() {
	AppLogoHeader()
}