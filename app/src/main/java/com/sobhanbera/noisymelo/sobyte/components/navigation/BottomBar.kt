package com.sobhanbera.noisymelo.sobyte.components.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sobhanbera.noisymelo.sobyte.components.SobyteLinearGradient
import com.sobhanbera.noisymelo.sobyte.configs.ACTUAL_BOTTOM_BAR_WIDTH
import com.sobhanbera.noisymelo.sobyte.model.ScreenParams
import com.sobhanbera.noisymelo.sobyte.viewmodels.CorePlayerViewModel
import com.sobhanbera.noisymelo.sobyte.viewmodels.CorePlayerViewModelState

/**
 * Bottom bar navigation
 * @param navController [NavHostController]
 */
@Composable
fun BottomBar(
	navController: NavHostController,
	screensParamsList: List<ScreenParams>,

	corePlayerViewModel: CorePlayerViewModel,
	corePlayerState: CorePlayerViewModelState,
) {
	// get the current destination & check if it is a bottom bar destination
	val navBackStackEntry = navController.currentBackStackEntryAsState() // navController.currentBackStackEntryAsState()
	val currentDestination = navBackStackEntry.value?.destination

	// get the current destination and check if it is a bottom bar destination
	val bottomBarDestination = screensParamsList.any { it.screenRouteName == currentDestination?.route }

	/**
	 * if the current destination belongs to music player then show the color
	 * that belongs to the current song's artwork,
	 * else this will be null
	 */
	val bottomBarColor = remember(currentDestination?.route, corePlayerState.colorPalette) {
		// if the current route is exactly for music player interface, then use the dominant color
		if (currentDestination?.route == ScreenParams.MUSIC_PLAYER_SCREEN.screenRouteName) {
			corePlayerState.colorPalette?.darkMutedColor?.copy(alpha = 0f) ?: null
		} else {
			null
		}
	}
	// animated value of the above color
	val animatedBottomBarColor = animateColorAsState(
		bottomBarColor ?: MaterialTheme.colors.background,
		animationSpec = spring(stiffness = 1111f)
	)

	SobyteLinearGradient(
		colors = listOf(
			MaterialTheme.colors.primary.copy(alpha = 0f),
			animatedBottomBarColor.value,
		),
		gradientAngle = 270f,
		modifier = Modifier
			.fillMaxWidth()
			.padding(0.dp, 0.dp)
	) {
		// if the current destination is a bottom bar destination, then show the bottom bar
		if (bottomBarDestination) {
			BottomNavigation(
				backgroundColor = MaterialTheme.colors.background.copy(alpha = 0f),
				modifier = Modifier
					.padding(0.dp, 0.dp),
				elevation = 0.dp,
			) {
				// this is the parent of the main wrapper of the bottom bar
				Row(
					horizontalArrangement = Arrangement.Center,
					modifier = Modifier.fillMaxHeight().fillMaxWidth()
				) {
					// parent of actual bottom bar buttons
					Row(
						horizontalArrangement = Arrangement.Center,
						verticalAlignment = Alignment.CenterVertically,
						modifier = Modifier
							.fillMaxHeight()
							.width(ACTUAL_BOTTOM_BAR_WIDTH.dp),
					) {
						screensParamsList.forEach { screen ->
							// add a bottom bar item for each screen
							// AddNewBottomBarItem is a composable function
							AddNewBottomBarItem(
								screen = screen,
								currentDestination = currentDestination,
								navController = navController,
								numberOfItems = screensParamsList.size,
							)
						}
					}
				}
			}
		}
	}
}
