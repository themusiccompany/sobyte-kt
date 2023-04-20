package com.sobhanbera.noisymelo.sobyte.model

object NavigationTree {
	object AuthNavigationTree {
		val name = ScreenParams.AUTH_NAVIGATION.screenRouteName

		val LANDING_SCREEN = ScreenParams.LANDING_SCREEN.screenRouteName
		val SIGN_IN_SCREEN = ScreenParams.SIGN_IN_SCREEN.screenRouteName
		val SIGN_UP_SCREEN = ScreenParams.SIGN_UP_SCREEN.screenRouteName
	}

	object MainNavigationTree {
		val name = ScreenParams.MAIN_APP_NAVIGATION.screenRouteName

		val MUSIC_PLAYER_SCREEN = ScreenParams.MUSIC_PLAYER_SCREEN.screenRouteName
		val HOME_EXPLORE_SCREEN = ScreenParams.HOME_EXPLORE_SCREEN.screenRouteName
		val SEARCH_SCREEN = ScreenParams.SEARCH_SCREEN.screenRouteName
		val PROFILE_SCREEN = ScreenParams.PROFILE_SCREEN.screenRouteName

		val SETTING_SCREEN = ScreenParams.SETTING_SCREEN.screenRouteName
		val EDIT_PROFILE_SCREEN = ScreenParams.EDIT_PROFILE_SCREEN.screenRouteName
	}
}