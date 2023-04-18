package com.sobhanbera.noisymelo.sobyte.model

object NavigationTree {
	object AuthNavigationTree {
		const val name = "AUTH_NAVIGATION"

		const val LANDING_SCREEN = "LANDING_SCREEN"
		const val SIGN_IN_SCREEN = "SIGN_IN_SCREEN"
		const val SIGN_UP_SCREEN = "SIGN_UP_SCREEN"
	}

	object MainNavigationTree {
		const val name = "MAIN_APP_NAVIGATION"

		const val MUSIC_PLAYER_SCREEN = "MUSIC_PLAYER_SCREEN"
		const val HOME_EXPLORE_SCREEN = "HOME_EXPLORE_SCREEN"
		const val SEARCH_SCREEN = "SEARCH_SCREEN"
		const val PROFILE_SCREEN = "PROFILE_SCREEN"

		const val SETTING_SCREEN = "SETTING_SCREEN"
		const val EDIT_PROFILE_SCREEN = "EDIT_PROFILE_SCREEN"
	}
}