package com.su.io24_compose_experimental.contextualflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.su.io24_compose_experimental.ui.util.randomColor

/*
 val overFlow = ContextualFlowRowOverflow.expandIndicator {
        ColorBoxItem(text = "+ ${colorItems.size - this.shownItemCount}",)
ContextualFlowRow(itemCount,maxLines,overflow)
* */


@Preview
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SampleContextualFlowRow(modifier: Modifier = Modifier) {
    val colorItems = remember {
        (0..10).map { randomColor() }.toList()
    }

    val overflow = ContextualFlowRowOverflow.expandIndicator {
        ColorBoxItem(
            text = "+${colorItems.size - this.shownItemCount}",)
    }

    ContextualFlowRow(itemCount = colorItems.size,
        overflow = overflow) {
        ColorBoxItem(text = "$it",
            color = colorItems[it])
    }
}

@Preview
@Composable
fun ColorBoxItem(
    text: String = "",
    color: Color = Color.DarkGray
) {
    Box(
        Modifier
            .size(80.dp)
            .background(color, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text)
    }
}