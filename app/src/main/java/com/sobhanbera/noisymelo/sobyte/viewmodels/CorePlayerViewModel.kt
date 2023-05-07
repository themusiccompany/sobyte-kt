package com.sobhanbera.noisymelo.sobyte.viewmodels

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.sobhanbera.noisymelo.sobyte.R
import com.sobhanbera.noisymelo.sobyte.model.ColorPalette
import com.sobhanbera.noisymelo.sobyte.model.DefaultColorPalette
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import javax.inject.Inject

data class CorePlayerViewModelState(
	val imageURL: String? = "",
	val imageBitmap: ImageBitmap? = null,
	val colorPalette: ColorPalette? = DefaultColorPalette
)

/**
 * this view model is used to store the state of the core player
 * all data related to currently playing song like image, url, title, artist and more
 *
 * also image bitmap, its color palette and more...
 */
@HiltViewModel
class CorePlayerViewModel @Inject constructor(): ViewModel() {
	// state to hold all the data for current status of the app
	private val _state = MutableStateFlow(CorePlayerViewModelState(
		colorPalette = DefaultColorPalette
	))
	// public state to be used by the app
	val state = _state.asStateFlow()

	/**
	 * set the image url and update the image bitmap and color palette
	 *
	 * @param imageURL url of the image
	 * @return Unit
	 */
	fun setImageUri(imageURL: String) {
		viewModelScope.launch {
			// get the bitmap from the image's url
			val bitmap = withContext(Dispatchers.IO) {
				URL(imageURL).openStream().use {
					BitmapFactory.decodeStream(it)
				}
			}
			// generate the color palette from the bitmap
			val palette = Palette.from(bitmap).generate()

			/*
			 * and finally update the state
			 * this will update the image bitmap and color palette
			 */
			_state.update { previousState ->
				previousState.copy(
					imageURL = imageURL,
					imageBitmap = bitmap.asImageBitmap(),
					colorPalette = object: ColorPalette {
						override val dominantColor: Color = Color(palette.getDominantColor(R.string.color_background))
						override val lightVibrantColor: Color = Color(palette.getLightVibrantColor(R.string.color_background))
						override val darkVibrantColor: Color = Color(palette.getDarkVibrantColor(R.string.color_background))
						override val lightMutedColor: Color = Color(palette.getLightMutedColor(R.string.color_background))
						override val darkMutedColor: Color = Color(palette.getDarkMutedColor(R.string.color_background))
//						override val swatches: List<Color> = palette.swatches.map { Color(it.rgb) }
					}
				)
			}
		}
	}
}