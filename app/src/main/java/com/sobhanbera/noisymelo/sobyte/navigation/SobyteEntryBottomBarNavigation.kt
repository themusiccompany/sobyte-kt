package com.sobhanbera.noisymelo.sobyte.navigation

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sobhanbera.noisymelo.sobyte.components.navigation.BottomBar
import com.sobhanbera.noisymelo.sobyte.controllers.ScreenController
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree

import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.MUSIC_PLAYER_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.HOME_EXPLORE_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.SEARCH_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.PROFILE_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.SETTING_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.EDIT_PROFILE_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.ScreenParams

import com.sobhanbera.noisymelo.sobyte.screens.core.MusicPlayerScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.HomeExploreScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.SearchScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.ProfileScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.common.SettingScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.common.EditProfileScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SobyteEntryBottomBarNavigation(
	mainNavController: NavHostController = rememberNavController(),
	screenController: ScreenController
) {
	// allowed screens in the bottom navigation bar to be shown
	val screens = listOf(
		ScreenParams.MUSIC_PLAYER_SCREEN,
		ScreenParams.HOME_EXPLORE_SCREEN,
		ScreenParams.SEARCH_SCREEN,
		ScreenParams.PROFILE_SCREEN,
	)

	Scaffold(
		bottomBar = {
			BottomBar(
				navController = mainNavController,
				screensParamsList = screens
			)
		}
	) {
		NavHost(
			mainNavController,
			route = MainNavigationTree.name,
			startDestination = MUSIC_PLAYER_SCREEN
		) {
			// these four screens will be available through the bottom bar navigation
			composable(MUSIC_PLAYER_SCREEN) {
				MusicPlayerScreen(mainNavController, screenController)
			}
			composable(HOME_EXPLORE_SCREEN) {
				HomeExploreScreen(mainNavController, screenController)
			}
			composable(SEARCH_SCREEN) {
				SearchScreen(mainNavController, screenController)
			}
			composable(PROFILE_SCREEN) {
				ProfileScreen(mainNavController, screenController)
			}

			// other common screens
			composable(SETTING_SCREEN) {
				SettingScreen(mainNavController, screenController)
			}
			composable(EDIT_PROFILE_SCREEN) {
				EditProfileScreen(mainNavController, screenController)
			}
		}
	}
}
