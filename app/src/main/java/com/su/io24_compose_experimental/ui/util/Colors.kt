package com.su.io24_compose_experimental.ui.util

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

fun randomColor() = Color(
    red = Random.nextFloat(),
    green = Random.nextFloat(),
    blue = Random.nextFloat(),
    alpha = 1f
)