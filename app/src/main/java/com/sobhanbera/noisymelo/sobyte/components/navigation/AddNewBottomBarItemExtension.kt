package com.sobhanbera.noisymelo.sobyte.components.navigation

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.sobhanbera.noisymelo.sobyte.configs.ACTUAL_BOTTOM_BAR_WIDTH
import com.sobhanbera.noisymelo.sobyte.configs.DEFAULT_ICON_SIZE
import com.sobhanbera.noisymelo.sobyte.configs.DEVICE_SCREEN_WIDTH
import com.sobhanbera.noisymelo.sobyte.funextension.scaleOnClick
import com.sobhanbera.noisymelo.sobyte.model.ScreenParams
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras
import com.sobhanbera.noisymelo.sobyte.utils.navigateToScreen
import kotlin.text.Typography

/**
 * Add new bottom bar item
 * @param screen [ScreenParams] screen params
 * @param currentDestination [NavDestination] current destination
 * @param navController [NavHostController] nav controller
 * @param numberOfItems [Int] number of items in the bottom bar, needed to calculate the width of each item
 * @see BottomBar
 * @see BottomNavigationItem
 * @see LocalContentColor
 */
@Composable
fun RowScope.AddNewBottomBarItem(
	screen: ScreenParams,
	currentDestination: NavDestination?,
	navController: NavHostController,
	numberOfItems: Int,
) {
	val selected = currentDestination?.hierarchy?.any {
		it.route == screen.screenRouteName
	} == true
	val color = if (selected) MaterialTheme.colors.extras.text else LocalContentColor.current.copy(alpha = ContentAlpha.disabled)

	Box(
		modifier = Modifier
			.fillMaxHeight()
			.width((ACTUAL_BOTTOM_BAR_WIDTH / numberOfItems).dp)
			.scaleOnClick(0.85f) {
				// if this tab or screen is already selected then don't navigate to it again
				if (selected) return@scaleOnClick

				navController.navigate(screen.screenRouteName) {
					// popUpTo(navController.graph.findStartDestination().id)
					// launchSingleTop = true
				}
			}
	) {
		Column(
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight()
		) {
			// animated icon shift on click
			Crossfade(targetState = selected) {
				if (it) {
					Icon(
						screen.activeIcon ?: Icons.Outlined.MusicNote,
						contentDescription = "",
						tint = color,
						modifier = Modifier.size(screen.activeIconSize.dp)
					)
				} else {
					Icon(
						screen.inActiveIcon ?: Icons.Outlined.MusicNote,
						contentDescription = "",
						tint = color,
						modifier = Modifier.size(screen.inActiveIconSize.dp)
					)
				}
			}

			Text(
				text = screen.title,
				color = color,
				style = MaterialTheme.typography.h6.copy(
					fontSize = 10.sp,
				),
			)
		}
	}
}