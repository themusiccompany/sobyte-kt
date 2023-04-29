package com.sobhanbera.noisymelo.sobyte.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Dns
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.sharp.GridView
import androidx.compose.ui.graphics.vector.ImageVector
import com.sobhanbera.noisymelo.sobyte.configs.DEFAULT_ICON_SIZE

enum class ScreenParams(
	val screenRouteName: String,
	val title: String,
	val activeIcon: ImageVector? = null,
	val inActiveIcon: ImageVector? = null,
	val activeIconSize: Int = DEFAULT_ICON_SIZE,
	val inActiveIconSize: Int = DEFAULT_ICON_SIZE,
) {
	// all authentication related screens and its root navigation
	AUTH_NAVIGATION("AUTH_NAVIGATION", "",),
	LANDING_SCREEN("LANDING_SCREEN", "Landing"),
	SIGN_IN_SCREEN("SIGN_IN_SCREEN", "Login"),
	SIGN_UP_SCREEN("SIGN_UP_SCREEN", "Register"),

	// all main app related screens and its root navigation
	MAIN_APP_NAVIGATION("MAIN_APP_NAVIGATION", ""),
	HOME_EXPLORE_SCREEN(
		"HOME_EXPLORE_SCREEN", "Explore",
		Icons.Sharp.GridView, Icons.Outlined.GridView,
		DEFAULT_ICON_SIZE, DEFAULT_ICON_SIZE
	),
	MUSIC_PLAYER_SCREEN(
		"MUSIC_PLAYER_SCREEN", "Sobyte",
		Icons.Rounded.PlayArrow, Icons.Outlined.PlayArrow,
		DEFAULT_ICON_SIZE + 6, DEFAULT_ICON_SIZE + 6
	),
	PROFILE_SCREEN(
		"PROFILE_SCREEN", "You",
		Icons.Filled.Dns, Icons.Outlined.Dns,
		DEFAULT_ICON_SIZE, DEFAULT_ICON_SIZE
	),
	SEARCH_SCREEN(
		"SEARCH_SCREEN", "Search",
		Icons.Filled.Circle, Icons.Outlined.Circle,
		DEFAULT_ICON_SIZE, DEFAULT_ICON_SIZE
	),
	SETTING_SCREEN("SETTING_SCREEN", "Settings"),
	EDIT_PROFILE_SCREEN("EDIT_PROFILE_SCREEN", "Edit Profile"),
}