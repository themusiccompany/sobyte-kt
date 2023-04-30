package com.sobhanbera.noisymelo.sobyte.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.mikepenz.iconics.compose.Image
import com.mikepenz.iconics.typeface.IIcon
import com.sobhanbera.noisymelo.sobyte.configs.DEFAULT_ICON_SIZE
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras

/**
 * custom icon component
 * @see [IIcon]
 *
 * @param icon icon to render
 * @param colorFilter color filter to apply to the icon
 * @param modifier modifier to apply to the icon
 */
@Composable
@NonRestartableComposable
fun SobyteIcon(
	icon: IIcon,
	colorFilter: ColorFilter = ColorFilter.tint(MaterialTheme.colors.extras.text),
	modifier: Modifier = Modifier
) {
	Image(
		icon,
		colorFilter = colorFilter,
		modifier = Modifier
			.size(DEFAULT_ICON_SIZE.dp)
			.then(modifier)
	)
}

/**
 * custom icon component
 * same as [Icon] but with [ImageVector] instead of [IIcon]
 *
 * @param imageVector icon to render
 * @param contentDescription content description for the icon
 * @param modifier modifier to apply to the icon
 * @param tint tint to apply to the icon
 */
@Composable
@NonRestartableComposable
fun SobyteIcon(
	imageVector: ImageVector,
	contentDescription: String?,
	modifier: Modifier = Modifier,
	tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
	Icon(
		painter = rememberVectorPainter(imageVector),
		contentDescription = contentDescription,
		modifier = modifier,
		tint = tint
	)
}