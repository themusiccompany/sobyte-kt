package com.sobhanbera.noisymelo.sobyte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sobhanbera.noisymelo.sobyte.ui.theme.SobyteTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			SobyteTheme {

			}
		}
	}
}
