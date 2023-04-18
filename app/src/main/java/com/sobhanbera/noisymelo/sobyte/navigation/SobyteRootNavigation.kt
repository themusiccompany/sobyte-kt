package com.sobhanbera.noisymelo.sobyte.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.AuthNavigationTree
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.AuthNavigationTree.LANDING_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.AuthNavigationTree.SIGN_IN_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.AuthNavigationTree.SIGN_UP_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.MUSIC_PLAYER_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.HOME_EXPLORE_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.SEARCH_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.PROFILE_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.SETTING_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree.EDIT_PROFILE_SCREEN

import com.sobhanbera.noisymelo.sobyte.screens.auth.LandingScreen
import com.sobhanbera.noisymelo.sobyte.screens.auth.SignInScreen
import com.sobhanbera.noisymelo.sobyte.screens.auth.SignUpScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.MusicPlayerScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.HomeExploreScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.SearchScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.ProfileScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.common.SettingScreen
import com.sobhanbera.noisymelo.sobyte.screens.core.common.EditProfileScreen

/**
 * App's root navigation
 * Both Authentication and root app navigator
 */
@Composable
fun SobyteRootNavigation(
	navController: NavHostController
) {

	NavHost(navController, AuthNavigationTree.name) {
		// authentication screen stack
		navigation(LANDING_SCREEN, AuthNavigationTree.name) {
			// authentication screens
			composable(LANDING_SCREEN) {
				LandingScreen(navController)
			}
			composable(SIGN_IN_SCREEN) {
				SignInScreen(navController)
			}
			composable(SIGN_UP_SCREEN) {
				SignUpScreen(navController)
			}
		}

		// stack of screens for core application flow
		navigation(MUSIC_PLAYER_SCREEN, MainNavigationTree.name) {
			// these four screens will be available through the bottom bar navigation
			composable(MUSIC_PLAYER_SCREEN) {
				MusicPlayerScreen(navController)
			}
			composable(HOME_EXPLORE_SCREEN) {
				HomeExploreScreen(navController)
			}
			composable(SEARCH_SCREEN) {
				SearchScreen(navController)
			}
			composable(PROFILE_SCREEN) {
				ProfileScreen(navController)
			}

			// other common screens
			composable(SETTING_SCREEN) {
				SettingScreen(navController)
			}
			composable(EDIT_PROFILE_SCREEN) {
				EditProfileScreen(navController)
			}
		}
	}
}
