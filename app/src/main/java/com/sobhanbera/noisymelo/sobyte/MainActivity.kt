package com.sobhanbera.noisymelo.sobyte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.sobhanbera.noisymelo.sobyte.controllers.ScreenController
import com.sobhanbera.noisymelo.sobyte.ui.theme.SobyteTheme
import com.sobhanbera.noisymelo.sobyte.navigation.SobyteRootNavigation
import com.sobhanbera.noisymelo.sobyte.viewmodels.CorePlayerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		WindowCompat.setDecorFitsSystemWindows(window, false)

		setContent {
			SobyteTheme {
				// navController is the root navigation controller
				val navController = rememberNavController()
				val screenController = ScreenController(navController) // This is the screen controller made from the root navigation controller

				val corePlayerViewModel: CorePlayerViewModel = viewModel()
				val corePlayerState = corePlayerViewModel.state.collectAsState().value

				SobyteRootNavigation(
					navController = navController,
					screenController = screenController,

					corePlayerViewModel = corePlayerViewModel,
					corePlayerState = corePlayerState,
				)
			}
		}
	}
}
