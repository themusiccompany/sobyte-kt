package com.sobhanbera.noisymelo.sobyte.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sobhanbera.noisymelo.sobyte.R
import com.sobhanbera.noisymelo.sobyte.controllers.ScreenController
import com.sobhanbera.noisymelo.sobyte.model.ScreenParams
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras

@Composable
fun LandingScreen(
	navController: NavController,
	screenController: ScreenController
) {
	Surface(
		color = MaterialTheme.colors.extras.transparent
	) {
		Image(
			painter = painterResource(id = R.drawable.logo_with_name_bold),
			contentDescription = "",
			modifier = Modifier
				.width(145.dp)
				.clickable { screenController.navigateTo(ScreenParams.SIGN_IN_SCREEN) }
		)
	}
}
