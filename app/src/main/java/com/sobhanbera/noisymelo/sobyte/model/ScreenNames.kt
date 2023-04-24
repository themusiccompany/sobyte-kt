package com.sobhanbera.noisymelo.sobyte.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

enum class ScreenParams(
	val screenRouteName: String,
	val title: String,
	val activeIcon: ImageVector? = null,
	val inActiveIcon: ImageVector? = null
) {
	// all authentication related screens and its root navigation
	AUTH_NAVIGATION("AUTH_NAVIGATION", "",),
	LANDING_SCREEN("LANDING_SCREEN", "Landing"),
	SIGN_IN_SCREEN("SIGN_IN_SCREEN", "Login"),
	SIGN_UP_SCREEN("SIGN_UP_SCREEN", "Register"),

	// all main app related screens and its root navigation
	MAIN_APP_NAVIGATION("MAIN_APP_NAVIGATION", ""),
	MUSIC_PLAYER_SCREEN(
		"MUSIC_PLAYER_SCREEN",
		"Sobyte",
		Icons.Filled.MusicNote,
		Icons.Outlined.MusicNote,
	),
	HOME_EXPLORE_SCREEN(
		"HOME_EXPLORE_SCREEN",
		"Explore",
		Icons.Filled.Home,
		Icons.Outlined.Home,
	),
	SEARCH_SCREEN(
		"SEARCH_SCREEN",
		"Search",
		Icons.Filled.Search,
		Icons.Outlined.Search,
	),
	PROFILE_SCREEN(
		"PROFILE_SCREEN",
		"You",
		Icons.Filled.Person,
		Icons.Outlined.Person,
	),
	SETTING_SCREEN("SETTING_SCREEN", "Settings"),
	EDIT_PROFILE_SCREEN("EDIT_PROFILE_SCREEN", "Edit Profile"),
}