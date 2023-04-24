package com.sobhanbera.noisymelo.sobyte.components

import android.widget.Toast
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.sobhanbera.noisymelo.sobyte.ui.theme.extras

@Composable
fun HyperlinkText(
	modifier: Modifier = Modifier,
	text: String,
	linkTexts: Map<String, String>,
	textStyle: TextStyle = TextStyle.Default,
	textColor: Color = MaterialTheme.colors.extras.text,
	linkColor: Color,
	linkTextFontWeight: FontWeight = FontWeight.Normal,
	linkTextDecoration: TextDecoration = TextDecoration.Underline,
	fontSize: TextUnit = TextUnit.Unspecified,
	fallbackFunction: () -> Unit = {},
) {
	val annotatedString = buildAnnotatedString {
		append(text)

		for((key, value) in linkTexts) {
			// get the index from where to where does the key exists in the
			// given hyperlink text in the fulltext
			val startIndex = text.indexOf(key)
			val endIndex = startIndex + key.length

			addStyle(
				style = SpanStyle(
					color = linkColor,
					fontSize = fontSize,
					fontWeight = linkTextFontWeight,
					textDecoration = linkTextDecoration
				),
				start = startIndex,
				end = endIndex
			)
			addStringAnnotation(
				tag = "URL",
				annotation = value,
				start = startIndex,
				end = endIndex
			)
		}

		addStyle(
			style = SpanStyle(
				fontSize = fontSize,
			),
			start = 0,
			end = text.length
		)
	}

	val uriHandler = LocalUriHandler.current

	ClickableText(
		text = annotatedString,
		modifier = modifier,
		style = textStyle.copy(
			color = textColor,
			textAlign = TextAlign.Center,
			lineHeight = 20.sp
		),
		onClick = {
			annotatedString.getStringAnnotations("URL", it, it)
				.firstOrNull()?.let { annotation ->
					try {
						uriHandler.openUri(annotation.item)
					} catch (e: Exception) {
						fallbackFunction()
					}
				}
		},
	)
}