package com.sobhanbera.noisymelo.sobyte.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.material.Typography

/**
 * this interface is a model that contains data about extra
 * typography needed in the UI
 * this will be accessed using MaterialTheme.typography.extras
 * @see [Typography.extras]
 */
interface ExtraTypography {
	val err: TextStyle
}