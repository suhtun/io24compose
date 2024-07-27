package com.su.io24_compose_experimental.carousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.su.io24_compose_experimental.R
import com.su.io24_compose_experimental.ui.util.randomColor

/*
HorizontalMultiBrowseCarousel, HorizontalUncontainedCarousel
val state = rememberCarouselState {fruits.size}
HorizontalMultiBrowseCarousel(state,
            preferredItemWidth = 186.dp,
            itemSpacing = 10.dp,
        )
Modifier.maskClip(shape = MaterialTheme.shapes.large)
* */

@Composable
fun SampleCarousel(modifier: Modifier = Modifier) {
    val fruits = mutableListOf(
        R.drawable.grapes,
        R.drawable.lemon,
        R.drawable.strawberry,
        R.drawable.watermelon,
        R.drawable.passionfruit,
    )


}

@Composable
private fun Item(drawable: Int = R.drawable.strawberry) {
    Box(
        modifier = Modifier
            .size(320.dp)
            .background(color = randomColor()),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
        )
    }
}