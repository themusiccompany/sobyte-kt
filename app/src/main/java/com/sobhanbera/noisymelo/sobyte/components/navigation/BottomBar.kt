package com.sobhanbera.noisymelo.sobyte.components.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sobhanbera.noisymelo.sobyte.model.ScreenParams

/**
 * Bottom bar navigation
 * @param navController [NavHostController]
 */
@Composable
fun BottomBar(
	navController: NavHostController,
	screensParamsList: List<ScreenParams>
) {
	// get the current destination & check if it is a bottom bar destination
	val navBackStackEntry = navController.currentBackStackEntryAsState() // navController.currentBackStackEntryAsState()
	val currentDestination = navBackStackEntry.value?.destination

	// get the current destination and check if it is a bottom bar destination
	val bottomBarDestination = screensParamsList.any { it.screenRouteName == currentDestination?.route }

	// if the current destination is a bottom bar destination, then show the bottom bar
	if (bottomBarDestination) {
		BottomNavigation(
			backgroundColor = MaterialTheme.colors.primary.copy(alpha = 1f),
			modifier = Modifier
				.padding(10.dp, 10.dp)
				.clip(shape = RoundedCornerShape(100.dp, 100.dp, 100.dp, 100.dp))
		) {
			screensParamsList.forEach { screen ->
				// add a bottom bar item for each screen
				// AddNewBottomBarItem is a composable function
				AddNewBottomBarItem(
					screen = screen,
					currentDestination = currentDestination,
					navController = navController
				)
			}
		}
	}
}
