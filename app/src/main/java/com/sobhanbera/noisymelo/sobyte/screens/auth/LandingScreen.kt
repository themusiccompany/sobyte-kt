package com.sobhanbera.noisymelo.sobyte.screens.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sobhanbera.noisymelo.sobyte.R
import com.sobhanbera.noisymelo.sobyte.components.SobyteStatusBar
import com.sobhanbera.noisymelo.sobyte.controllers.ScreenController
import com.sobhanbera.noisymelo.sobyte.funextension.gradientBackground
import com.sobhanbera.noisymelo.sobyte.funextension.scaleOnClick
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LandingScreen(
	navController: NavController,
	screenController: ScreenController
) {
	Scaffold {
		// change the status bar color, and blending it with the below gradient-background
		SobyteStatusBar(
			color = MaterialTheme.colors.extras.primaryGradients[0]
		)

		Surface(
			color = MaterialTheme.colors.extras.transparent,
			modifier = Modifier
				.fillMaxSize()
				.gradientBackground(
					MaterialTheme.colors.extras.primaryGradients,
					angle = 315f
				),
			contentColor = MaterialTheme.colors.extras.text,
		) {
			Column {
				Image(
					painter = painterResource(id = R.drawable.logo_with_name),
					contentDescription = "",
					modifier = Modifier
						.width(146.dp)
						.scaleOnClick(0.98f)
				)
			}
		}
	}
}

