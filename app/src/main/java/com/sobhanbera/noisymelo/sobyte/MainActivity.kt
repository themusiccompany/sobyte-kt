package com.sobhanbera.noisymelo.sobyte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.sobhanbera.noisymelo.sobyte.ui.theme.SobyteTheme
import com.sobhanbera.noisymelo.sobyte.navigation.SobyteRootNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			SobyteTheme {
				val navController = rememberNavController()

				SobyteRootNavigation(navController = navController)
			}
		}
	}
}
