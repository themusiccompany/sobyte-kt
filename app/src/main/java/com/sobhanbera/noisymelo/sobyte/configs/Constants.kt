package com.sobhanbera.noisymelo.sobyte.configs

import com.sobhanbera.noisymelo.sobyte.R
import com.sobhanbera.noisymelo.sobyte.utils.getStatusBarHeight

const val SOBYTE_APP_NAME = "Sobyte"
const val SOBYTE_APP_VERSION = "1.0.0"
const val SOBYTE_APP_VERSION_CODE = 1

const val SOBYTE_SLOGAN = "FEEL THE MUSIC"

// dimensions for app
val DEVICE_STATUS_BAR_HEIGHT: Int = getStatusBarHeight()

// resources for app logo
const val DEFAULT_LOGO_RESOURCE = R.drawable.logo_small
const val SMALL_LOGO_RESOURCE = R.drawable.logo_small
const val MEDIUM_LOGO_RESOURCE = R.drawable.logo_medium
const val LARGE_LOGO_RESOURCE = R.drawable.logo_large
// resources for app logo with name
const val DEFAULT_NAMED_LOGO_RESOURCE = R.drawable.logo_with_name
const val DEFAULT_BOLD_NAMED_LOGO_RESOURCE = R.drawable.logo_with_name_bold
// blur images
const val BLUR_10_RESOURCE = R.drawable.blur10
const val BLUR_20_RESOURCE = R.drawable.blur20

// dimensions for app logo
const val DEFAULT_LOGO_WIDTH = 202
const val DEFAULT_LOGO_HEIGHT = 261
const val SMALL_LOGO_WIDTH = 202 // same as default
const val SMALL_LOGO_HEIGHT = 261
const val MEDIUM_LOGO_WIDTH = 403 // double of default
const val MEDIUM_LOGO_HEIGHT = 520
const val LARGE_LOGO_WIDTH = 806 // double of medium & 4x of default
const val LARGE_LOGO_HEIGHT = 1040

// dimensions for app logos
const val DEFAULT_NAMED_LOGO_DIVISION_RATE = 20 // division rate for named logo
const val DEFAULT_LOGO_DIVISION_RATE = 10 // division rate for logo

const val DEFAULT_BLUR_RADIUS = 35f // default blur radius

// dimensions for app logo with name
const val DEFAULT_LOGO_RENDER_WIDTH = DEFAULT_LOGO_WIDTH / DEFAULT_LOGO_DIVISION_RATE
const val DEFAULT_LOGO_RENDER_HEIGHT = DEFAULT_LOGO_HEIGHT / DEFAULT_LOGO_DIVISION_RATE
const val SMALL_LOGO_RENDER_WIDTH = SMALL_LOGO_WIDTH / DEFAULT_LOGO_DIVISION_RATE
const val SMALL_LOGO_RENDER_HEIGHT = SMALL_LOGO_HEIGHT / DEFAULT_LOGO_DIVISION_RATE
const val MEDIUM_LOGO_RENDER_WIDTH = MEDIUM_LOGO_WIDTH / DEFAULT_LOGO_DIVISION_RATE
const val MEDIUM_LOGO_RENDER_HEIGHT = MEDIUM_LOGO_HEIGHT / DEFAULT_LOGO_DIVISION_RATE
const val LARGE_LOGO_RENDER_WIDTH = LARGE_LOGO_WIDTH / DEFAULT_LOGO_DIVISION_RATE
const val LARGE_LOGO_RENDER_HEIGHT = LARGE_LOGO_HEIGHT / DEFAULT_LOGO_DIVISION_RATE

const val TINY_ICON_SIZE = 22 // size of tiny icons
const val DEFAULT_ICON_SIZE = 24 // default icon size
const val SMALL_ICON_SIZE = 28 // somewhat larger than tiny and deafult icon
const val MEDIUM_ICON_SIZE = 32 // icon size for medium icons
const val LARGE_ICON_SIZE = 38 // large icons size
const val EXTRA_LARGE_ICON_SIZE = 45 // extra large icons size
const val PLAY_PAUSE_ICON_SIZE = 80 // icon size for play/pause button

// IMAGE CONSTANTS ABOUT QUALITIES.
const val DEFAULT_ARTWORK_SIZE = 200 // default image width and height in string...
const val DEFAULT_ARTWORK_QUALITY = 90 // default image quality in string...

const val DEFAULT_SMALL_ARTWORK_SIZE = 120 // default small/low quality image width and height in string...
const val DEFAULT_SMALL_ARTWORK_QUALITY = 90 // default small/low quality image quality in string...

const val DEFAULT_MEDIUM_ARTWORK_SIZE = 446 // default medium quality image width and height in string...
const val DEFAULT_MEDIUM_ARTWORK_QUALITY = 90 // default medium quality image quality in string...

const val DEFAULT_LARGE_ARTWORK_SIZE = 594 // default high quality image width and height in string...
const val DEFAULT_LARGE_ARTWORK_QUALITY = 100 // default high quality image quality in string...

const val DEFAULT_EXTRA_LARGE_ARTWORK_SIZE = 720 // default extra high/extreme quality image width and height in string...
const val DEFAULT_EXTRA_LARGE_ARTWORK_QUALITY = 100 // default extra high/extreme quality image quality in string...

// TODO: this value needs to be changed
const val DEFAULT_PLAYER_ARTWORK_SIZE = 720 // this could be changed as per need during development
const val DEFAULT_PLAYER_ARTWORK_QUALITY = 100 // this could be changed as per need during development

// below value should not be changed regarding the shades on notification panel
const val DEFAULT_NOTIFICATION_ARTWORK_SIZE = 300 // the size (width/height) of the image which will be shown in the notification of when a track is played short size of image would take less time to load and play the song faster then previously...
const val DEFAULT_NOTIFICATION_ARTWORK_QUALITY = 100 // the quality of the image which will be shown in the notification of when a track is played short size of image would take less time to load and play the song faster then previously...

// TODO: this value needs to be changed
const val TRACK_SHARE_ARTWORK_SIZE = 120 // the size of the image which will be used during sharing any track
const val TRACK_SHARE_ARTWORK_QUALITY = 100 // the quality of the image which will be used during sharing any track


// API RELATED CONSTANTS FOR MUSIC
// user agent while making api request
const val MUSIC_API_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.129 Safari/537.36"
// allowed languages during making api request...
const val MUSIC_API_ACCEPTED_LANGUAGE = "en-IN,en-US,HI,BN,en;q=0.5"
// type of music api request
const val MUSIC_API_NEXT = "next"
// currently it is public but plan is to make it private as env var
const val MUSIC_API_KEY = "AIzaSyC9XL3ZjWddXya6X74dJoCTL-WEYFDNX30"
// value type returned by music api
const val MUSIC_API_ALT = "json"


