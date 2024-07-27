package com.su.io24_compose_experimental.htmltext

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
I’m encountering an issue where AnnotatedString.fromHtml() does not apply link styles as expected. I’m not sure if this is related to the problem highlighted on the official page. Note this Saver doesn't preserve the LinkInteractionListener of the links.
You should handle this case manually if required (check https://issuetracker.google.com/issues/332901550 for an example)
val linkStyle = TextLinkStyles(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue))
AnnotatedString.fromHtml()
* */



@Composable
fun SampleHtmlText(modifier: Modifier = Modifier) {
    val htmlText =
        "This is an <b>example</b> with <a href='https://www.google.com'>inline links</a> and <i>HTML formatting</i>."

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
    }
}