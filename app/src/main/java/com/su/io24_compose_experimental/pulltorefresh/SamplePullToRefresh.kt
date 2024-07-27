package com.su.io24_compose_experimental.pulltorefresh

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

/*
PullToRefreshBox(isRefreshing = viewModel.isRefreshing,onRefresh = { viewModel.refresh() })
* */


@Preview
@Composable
fun SamplePullToRefresh(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        val viewModel = viewModel<PullToRefreshViewModel>()

        LazyColumn(Modifier.fillMaxSize()) {
            items(viewModel.itemCount) {
                ListItem({
                    Text(
                        text = "Item ${viewModel.itemCount - it}",
                        modifier = Modifier.animateItem()
                    )
                })
            }
        }
    }
}