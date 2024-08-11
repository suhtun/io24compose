package com.su.io24_compose_experimental.delightfului

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.su.io24_compose_experimental.R

const val maxImagSize = 260f
const val minImageSize = 120f

const val maxOffset = 260

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun SamplerNestedScroll(modifier: Modifier = Modifier) {

    var currentImageSize by remember {
        mutableStateOf(maxImagSize)
    }

    //you can set Image Offset also
//    var currentImageAlpha by remember {
//        mutableStateOf(maxOffset)
//    }

    var currentFabOffset by remember {
        mutableStateOf(maxOffset)
    }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection{
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {

                val delta = available.y.toInt()
                val newImageSize = currentImageSize+delta
                val perviousSize = currentImageSize
                currentImageSize = newImageSize.coerceIn(minImageSize, maxImagSize)
                val consumed = currentImageSize - perviousSize

                val sizeDelta = (currentImageSize - minImageSize)/ (maxImagSize- minImageSize)

                currentFabOffset = (sizeDelta * maxImagSize).toInt()
                return Offset(0f, consumed)
            }

            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                return super.onPostScroll(consumed, available, source)
            }
        }
    }
    Box(
        Modifier.nestedScroll(connection = nestedScrollConnection),
        contentAlignment = Alignment.TopCenter
    ) {
        val list by remember {
            mutableStateOf((1..30).toList())
        }
        Box(modifier = Modifier.padding(top = currentImageSize.dp)){
            LazyColumn {
                items(list.size, key = { it }) {

                    Card(
                        Modifier
                            .fillMaxWidth()
                            .height(58.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Item $it")
                        }
                    }
                    VerticalDivider(thickness = 2.dp)
                }
            }
        }

        Box(
            Modifier
                .size(currentImageSize.dp)
//                .graphicsLayer {
//                    alpha = currentImageAlpha
//                }
                .background(Color.Green, RoundedCornerShape(8.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_android),
                contentDescription = "android",
                tint = Color.White
            )
        }

        FloatingActionButton(
            onClick = { },
            Modifier
                .offset {
                    IntOffset(currentFabOffset, 0)
                }
                .padding(end = 16.dp, bottom = 16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                Icons.Filled.Add,
                "FAB"
            )
        }
    }
}
