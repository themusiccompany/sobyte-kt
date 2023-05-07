package com.sobhanbera.noisymelo.sobyte.screens.core

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sobhanbera.noisymelo.sobyte.components.AppLogoHeader
import com.sobhanbera.noisymelo.sobyte.components.SobyteLinearGradient
import com.sobhanbera.noisymelo.sobyte.components.StatusBarSpacer
import com.sobhanbera.noisymelo.sobyte.configs.MAX_DISPLAY_HEIGHT_OF_TRACK_ARTWORK_WRAPPER
import com.sobhanbera.noisymelo.sobyte.configs.TRACK_ARTWORK_HEIGHT
import com.sobhanbera.noisymelo.sobyte.configs.TRACK_ARTWORK_WIDTH
import com.sobhanbera.noisymelo.sobyte.controllers.ScreenController
import com.sobhanbera.noisymelo.sobyte.viewmodels.CorePlayerViewModel
import com.sobhanbera.noisymelo.sobyte.viewmodels.CorePlayerViewModelState

@Composable
fun MusicPlayerScreen(
	navController: NavController,
	screenController: ScreenController,

	corePlayerViewModel: CorePlayerViewModel,
	corePlayerState: CorePlayerViewModelState,
) {
	val image1 = "https://lh3.googleusercontent.com/EqN-4y9jQg91mt-94KKI8L1xu3olMS-Fh_WLL5tMlnqh1pSRzt-uWdnTVlY_GBnvLuA_WJmS6FYAXJlZtQ=w520-h520-l90-rj"
	val image2 = "https://lh3.googleusercontent.com/xpDEOr2TeqEn1QpXosXhqtj149FzNnTgAG3oqPnpTxTbQk-oceO90Sz4Axq0s4Jp_QLGQha_um6_EG3WGQ=w720-h720-l90-rj"
	val image3 = "https://lh3.googleusercontent.com/hH9yB1zSg20o9fA7kvccw2QSxj6BWxhdPa5RqTyMO6Foo7ZBEeeZGyAT045yM2DXxgt4Ge9QGpCaC_saow=w720-h720-l100-rj"

	val image = rememberSaveable { mutableStateOf(image1) }
	val colorPalette = corePlayerState.colorPalette

	LaunchedEffect(key1 = image.value) {
		corePlayerViewModel.setImageUri(image.value)
	}

	Box(
		modifier = Modifier.fillMaxSize(),
	) {
		Crossfade(
			targetState = colorPalette,
			animationSpec = tween(250)
		) { colorPalette ->
			if (colorPalette != null) {
				SobyteLinearGradient(
					colors = listOf(
						colorPalette.dominantColor,
						colorPalette.lightMutedColor,
						colorPalette.darkMutedColor,
					),
					parentModifier = Modifier
						.fillMaxSize(),
					modifier = Modifier
						.fillMaxSize(),
					gradientAngle = 270f
				) {}
			}
		}
	}

	Column {
		StatusBarSpacer()

		AppLogoHeader()

		Column(
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier
				.fillMaxWidth()
				.requiredHeight(MAX_DISPLAY_HEIGHT_OF_TRACK_ARTWORK_WRAPPER.dp),
		) {
			AsyncImage(
				model = image.value,
				contentDescription = "",
				modifier = Modifier
					.height(TRACK_ARTWORK_HEIGHT.dp)
					.width(TRACK_ARTWORK_WIDTH.dp)
					.clickable {
						if (image.value == image1) {
							image.value = image2
						} else if (image.value == image2) {
							image.value = image3
						} else {
							image.value = image1
						}
					}
			)
		}
	}
}
