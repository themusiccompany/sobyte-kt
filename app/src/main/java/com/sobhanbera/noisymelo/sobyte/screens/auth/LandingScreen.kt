package com.sobhanbera.noisymelo.sobyte.screens.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AlternateEmail
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sobhanbera.noisymelo.sobyte.R
import com.sobhanbera.noisymelo.sobyte.components.*
import com.sobhanbera.noisymelo.sobyte.configs.APP_PRIVACY_POLICY_URL
import com.sobhanbera.noisymelo.sobyte.configs.APP_TERMS_AND_CONDITIONS_URL
import com.sobhanbera.noisymelo.sobyte.configs.SOBYTE_SLOGAN
import com.sobhanbera.noisymelo.sobyte.controllers.ScreenController
import com.sobhanbera.noisymelo.sobyte.funextension.scaleOnClick
import com.sobhanbera.noisymelo.sobyte.model.AppLogLevels
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras
import com.sobhanbera.noisymelo.sobyte.utils.showAppSnackbar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LandingScreen(
	navController: NavController,
	screenController: ScreenController
) {
	// to show the error message in this screen
	val scaffoldState = rememberScaffoldState()
	val coroutineScope = rememberCoroutineScope()

	Scaffold(
		scaffoldState = scaffoldState,
		snackbarHost = { AppSnackbarHost(it) },
	) {
		// change the status bar color, and blending it with the below gradient-background
		SobyteStatusBar(
			color = MaterialTheme.colors.extras.primaryGradients[0]
		)

		SobyteLinearGradient(
			colors = MaterialTheme.colors.extras.primaryGradients,
			modifier = Modifier.fillMaxSize()
		) {
			// the root column
			Column(
				verticalArrangement = Arrangement.SpaceBetween,
				modifier = Modifier
					.padding(
						top = 50.dp,
						bottom = 20.dp,
						start = 20.dp,
						end = 20.dp
					)
			) {
				// column to hold the logo and the app slogan
				Column {
					Image(
						painter = painterResource(id = R.drawable.logo_with_name),
						contentDescription = "app logo",
						modifier = Modifier
							.width(140.dp)
							.padding(vertical = 25.dp)
							.scaleOnClick(0.98f)
					)
					
					Text(
						text = SOBYTE_SLOGAN,
						style = MaterialTheme.typography.h1
					)
				}

				/**
				 * this colum contains the bottom part of this landing screen
				 * like register and login button and T&C link and more...
				 */
				Column(
					modifier = Modifier
				) {
					// holds buttons here...
					Column(
						verticalArrangement = Arrangement.Center,
						modifier = Modifier
							.padding(top = 150.dp)
					) {
						SobyteAuthButton(
							text = "Register For Free!",
							onClick = {

							},
							rightIcon = {
								Icon(Icons.Outlined.AlternateEmail, contentDescription = "email icon")
							},
						)
						
						Spacer(modifier = Modifier.height(20.dp))

						SobyteAuthButton(
							text = "Login with Email!",
							onClick = { /*TODO*/ },
							useSingleColor = true,
							rightIcon = {
								Icon(Icons.Outlined.AlternateEmail, contentDescription = "email icon")
							},
						)
					}

					// terms & conditions / privacy policy text
					Row(
						modifier = Modifier
							.padding(top = 20.dp)
							.fillMaxWidth(),
						horizontalArrangement = Arrangement.Center
					) {
						HyperlinkText(
							text = "By continuing, you agree to our\nPrivacy Policy & Terms of use.",
							linkTexts = mapOf(
								"Privacy Policy" to APP_PRIVACY_POLICY_URL,
								"Terms of use" to APP_TERMS_AND_CONDITIONS_URL
							),
							linkColor = Color.White,
							textStyle = MaterialTheme.typography.body2,
							textColor = MaterialTheme.colors.onSurface,
							fallbackFunction = {
								showAppSnackbar(
									"Can't open url in browser.",
									SnackbarDuration.Short,
									coroutineScope,
									scaffoldState,
									AppLogLevels.ERROR
								)
							}
						)
					}
				}
			}
		}
	}
}
