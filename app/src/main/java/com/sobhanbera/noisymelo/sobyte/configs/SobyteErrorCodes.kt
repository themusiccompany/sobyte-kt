package com.sobhanbera.noisymelo.sobyte.configs

/**
 * This file contains all the error codes that are used in the app
 * to show the user the error message
 * here every id must contain the prefix "SOBYTE_ERR__" so that
 * they can be filtered in logcat
 */
enum class SobyteErrorCodes(val id: String, val message: String = "") {
	ILLEGAL_ARGUMENT_EXCEPTION("SOBYTE_ERR__ILLEGAL_ARGUMENT", "Illegal Argument Exception"),
}
