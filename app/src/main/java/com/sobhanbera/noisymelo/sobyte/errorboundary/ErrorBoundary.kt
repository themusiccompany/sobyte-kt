package com.sobhanbera.noisymelo.sobyte.errorboundary

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sobhanbera.noisymelo.sobyte.configs.SobyteErrorCodes
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras

/**
 * This is a simple error boundary that can be used to show the user
 * the error message and also log the error in logcat
 * @param error the error code that is used to show the user the error message
 * @param extraMessage the extra message that can be used to show the user the extra message
 * @see SobyteErrorCodes
 */
@Composable
fun ErrorBoundary(
	error: SobyteErrorCodes,
	extraMessage: String = "",
) {
	// the full message that is shown to the user
	val fullMessage = error.message + " - " + extraMessage
	// output the error before rendering the error message
	Log.e(error.id, fullMessage)

	// show the error message in the UI
	// as a fallback
	Box(
		modifier = Modifier
			.background(MaterialTheme.colors.extras.onWarning)
			.padding(2.dp),
	) {
		Text(
			text = "Error: ${error.id}",
			style = MaterialTheme.typography.extras.err, // getting the extra typography style from the theme
			color = MaterialTheme.colors.extras.onDanger,
		)
	}
}