package com.su.io24_compose_experimental.lazylistanims

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SampleLazyListAnimatedItem(modifier: Modifier = Modifier) {
    var list by remember { mutableStateOf((1..5).toList()) }
    Column(modifier = modifier.padding(16.dp)) {
        Button(onClick = { list = list + list.size.plus(1) }) {
            Text("Add new item")
        }
        Button(onClick = { list = list.shuffled() }) {
            Text("Shuffle")
        }
        LazyColumn {
            items(list.size, key = { it }) {
                Card(Modifier.animateItem()) {
                    Text("Item $it")
                }
            }
        }
    }
}