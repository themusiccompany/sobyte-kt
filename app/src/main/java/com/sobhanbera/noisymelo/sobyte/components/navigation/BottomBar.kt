package com.sobhanbera.noisymelo.sobyte.components.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
		BottomNavigation {
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

