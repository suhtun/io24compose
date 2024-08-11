package com.su.io24_compose_experimental

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navToNestedScroll:()->Unit ={},
    navToNavigableSuiteScaffold: () -> Unit = {},
    navToListDetail: () -> Unit = {},
    navToPager: () -> Unit = {},
    navToSharedElements: () -> Unit = {},
    navToContextualFlow: () -> Unit = {},
    navToHtmlString: () -> Unit = {},
    navToLazyListAnimation: () -> Unit = {},
    navToCarousel: () -> Unit = {},
    navToSegmentedButtons: () -> Unit = {},
    navToPullToRefresh: () -> Unit = {},
) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RoundedButton(
            text = "Preview NestedScroll",
            onClick = { navToNestedScroll() }
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview NavigableSuiteScaffold",
            onClick = { navToNavigableSuiteScaffold() }
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview ListDetailPaneScaffold",
            onClick = { navToListDetail() }
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview Pager",
            onClick = { navToPager() }
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview Shared Elements",
            onClick = navToSharedElements
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview Contextual Flow",
            onClick = navToContextualFlow
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview Html String",
            onClick = navToHtmlString
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview LazyList Animation",
            onClick = navToLazyListAnimation
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview Carousel",
            onClick = navToCarousel
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview Segmented Buttons",
            onClick = navToSegmentedButtons
        )
        Spacer(modifier = Modifier.height(10.dp))
        RoundedButton(
            text = "Preview PullToRefresh",
            onClick = navToPullToRefresh
        )

    }
}

@Preview
@Composable
fun RoundedButton(
    text: String = "",
    onClick: () -> Unit = {},
    background: Color = Color.White,
    textColor: Color = Color.DarkGray,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20), // Change the value to modify the roundness
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = background,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.DarkGray,
        )
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = textColor
        )
    }
}
