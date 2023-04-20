package com.sobhanbera.noisymelo.sobyte.screens.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sobhanbera.noisymelo.sobyte.components.SobyteStatusBar
import com.sobhanbera.noisymelo.sobyte.controllers.ScreenController
import com.sobhanbera.noisymelo.sobyte.funextension.gradientBackground
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
	//		Image(
	//			painter = painterResource(id = R.drawable.logo_with_name_bold),
	//			contentDescription = "",
	//			modifier = Modifier
	//				.width(145.dp)
	//		)
		}
	}
}

