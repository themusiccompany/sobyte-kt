package com.sobhanbera.noisymelo.sobyte.utils

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import com.sobhanbera.noisymelo.sobyte.components.AppSnackbarHost
import com.sobhanbera.noisymelo.sobyte.model.AppLogLevels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * this function basically uses the coroutine scope of the activity and
 * runs suspended functions inside it
 * in this case it is showing the snackbar of the screen/scaffold
 *
 * @param message the message to show in snackbar
 * @param duration duration of the message
 * @param coroutineScope the coroutine scope state of the screen
 * @param scaffoldState the scaffold state to show the snackbar
 * @param actionLabel an optional action label (used in @see [AppSnackbarHost] component to check how to control UI
 *
 * @see [SnackbarDuration]
 * @see [AppSnackbarHost]
 */
fun showAppSnackbar(
	message: String,
	duration: SnackbarDuration = SnackbarDuration.Short,

	coroutineScope: CoroutineScope,
	scaffoldState: ScaffoldState,

	actionLabel: AppLogLevels = AppLogLevels.INFO,
) {
	coroutineScope.launch {
		scaffoldState
			.snackbarHostState
			.showSnackbar(
				message,
				actionLabel.name,
				duration
			)
	}
}