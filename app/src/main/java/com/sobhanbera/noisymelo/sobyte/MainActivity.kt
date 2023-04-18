package com.sobhanbera.noisymelo.sobyte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.sobhanbera.noisymelo.sobyte.ui.theme.SobyteTheme
import com.sobhanbera.noisymelo.sobyte.navigation.SobyteRootNavigation
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			SobyteTheme {
				SobyteRootNavigation()
			}
		}
	}
}
