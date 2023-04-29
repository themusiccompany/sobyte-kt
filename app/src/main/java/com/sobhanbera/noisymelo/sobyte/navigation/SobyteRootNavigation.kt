package com.sobhanbera.noisymelo.sobyte.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.sobhanbera.noisymelo.sobyte.controllers.ScreenController

import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.AuthNavigationTree
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.AuthNavigationTree.LANDING_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.AuthNavigationTree.SIGN_IN_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.AuthNavigationTree.SIGN_UP_SCREEN
import com.sobhanbera.noisymelo.sobyte.model.NavigationTree.MainNavigationTree

import com.sobhanbera.noisymelo.sobyte.screens.auth.LandingScreen
import com.sobhanbera.noisymelo.sobyte.screens.auth.SignInScreen
import com.sobhanbera.noisymelo.sobyte.screens.auth.SignUpScreen
import com.sobhanbera.noisymelo.sobyte.viewmodels.CorePlayerViewModel
import com.sobhanbera.noisymelo.sobyte.viewmodels.CorePlayerViewModelState

/**
 * App's root navigation
 * Both Authentication and root app navigator
 */
@Composable
fun SobyteRootNavigation(
	navController: NavHostController,
	screenController: ScreenController,

	corePlayerViewModel: CorePlayerViewModel,
	corePlayerState: CorePlayerViewModelState,
) {
	// controls what to show on the screen
	val userLoggedIn = remember {
		mutableStateOf(true)
	}

	NavHost(
		navController,
		startDestination = if (userLoggedIn.value)
			MainNavigationTree.name
		else
			AuthNavigationTree.name
	) {
		// authentication screen stack
		navigation(LANDING_SCREEN, AuthNavigationTree.name) {
			// authentication screens
			composable(LANDING_SCREEN) {
				LandingScreen(navController, screenController, login = { userLoggedIn.value = true })
			}
			composable(SIGN_IN_SCREEN) {
				SignInScreen(navController, screenController)
			}
			composable(SIGN_UP_SCREEN) {
				SignUpScreen(navController, screenController)
			}
		}

		composable(MainNavigationTree.name) {
			SobyteEntryBottomBarNavigation(
				screenController = screenController,
				corePlayerState = corePlayerState,
				corePlayerViewModel = corePlayerViewModel,
			)
		}
	}
}
