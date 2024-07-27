package com.su.io24_compose_experimental.adaptivelayouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
val navigator = rememberListDetailPaneScaffoldNavigator<MenuItem>()
.navigateTo( pane = ListDetailPaneScaffoldRole.Detail/Extra, content = String)
get content = navigator.currentDestination?.content?
* */


@Composable
fun SampleListDetailPaneScaffold(modifier: Modifier = Modifier) {
    
}

@Preview
@Composable
private fun MainPane(navToDetail: (item: Int) -> Unit={}) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(30) {
            Text(
                text = "Menu $it",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        navToDetail(it)
                    })
        }
    }
}

@Preview
@Composable
private fun DetailPane(text:String="Empty",
                       navToExtra: (String) -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            AssistChip(onClick = {
                navToExtra("Option 1")
            }, label = { Text(text = "Option 1") })
            Spacer(modifier = Modifier.width(10.dp))
            AssistChip(onClick = {
                navToExtra("Option 2")
            }, label = { Text(text = "Option 2") })
            Spacer(modifier = Modifier.width(10.dp))
            AssistChip(onClick = {
                navToExtra("Option 3")
            }, label = { Text(text = "Option 3") })
        }
    }
}