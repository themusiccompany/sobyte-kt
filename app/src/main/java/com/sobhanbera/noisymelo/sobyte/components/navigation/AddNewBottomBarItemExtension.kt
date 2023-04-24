package com.sobhanbera.noisymelo.sobyte.components.navigation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.sobhanbera.noisymelo.sobyte.model.ScreenParams

/**
 * Add new bottom bar item
 * @param screen [ScreenParams]
 * @param currentDestination [NavDestination]
 * @param navController [NavHostController]
 * @see BottomBar
 * @see BottomNavigationItem
 * @see LocalContentColor
 */
@Composable
fun RowScope.AddNewBottomBarItem(
	screen: ScreenParams,
	currentDestination: NavDestination?,
	navController: NavHostController
) {
	val selected = currentDestination?.hierarchy?.any {
		it.route == screen.screenRouteName
	} == true
	Log.d("BottomBar", "AddNewBottomBarItem: ${currentDestination?.hierarchy}")

	BottomNavigationItem(
		label = {
			Text(text = screen.title)
		},
		icon = {
			Icon(
				// toggle between states for selected and unselected for the icons
				if (selected) screen.activeIcon ?: Icons.Outlined.MusicNote
				else screen.inActiveIcon ?: Icons.Outlined.MusicNote,
				contentDescription = "NavIcon"
			)
		},
		selected = selected,
		unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
		onClick = {
			navController.navigate(screen.screenRouteName) {
//				popUpTo(navController.graph.findStartDestination().id)
//				launchSingleTop = true
			}
		},
	)
}