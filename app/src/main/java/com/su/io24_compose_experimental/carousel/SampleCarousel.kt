package com.su.io24_compose_experimental.carousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleCarousel(modifier: Modifier = Modifier) {
    val fruits = mutableListOf(
        R.drawable.grapes,
        R.drawable.lemon,
        R.drawable.strawberry,
        R.drawable.watermelon,
        R.drawable.passionfruit,
    )


    Column {
        HorizontalMultiBrowseCarousel(state = rememberCarouselState {
            fruits.size
        }, preferredItemWidth = 180.dp, itemSpacing = 8.dp) { item ->
            Item(fruits[item])
        }

        Spacer(modifier = Modifier.height(20.dp))

        val fruits2 = mutableListOf(
            R.drawable.grapes,
            R.drawable.lemon,
            R.drawable.strawberry,
            R.drawable.watermelon,
            R.drawable.passionfruit,
        )

        HorizontalUncontainedCarousel(
            state = rememberCarouselState {
                fruits2.size
            }, itemWidth = 300.dp, itemSpacing = 8.dp
        ) { item ->
            Item(fruits2[item])

        }
    }

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