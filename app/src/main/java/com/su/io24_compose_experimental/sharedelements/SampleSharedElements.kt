package com.su.io24_compose_experimental.sharedelements

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.su.io24_compose_experimental.R
import com.su.io24_compose_experimental.ui.theme.Lime
import com.su.io24_compose_experimental.ui.theme.Lime300

/*
SharedTransitionLayout provide sharedTransitionScope this@SharedTransitionLayout
with(sharedTransitionScope) {
.sharedElement(state = rememberSharedContentState(key = SAMPLE_KEY),
               animatedVisibilityScope = animatedVisibilityScope)
}
* */
@Composable
fun SampleSharedElements(modifier: Modifier = Modifier) {
    var showDetail by remember {
        mutableStateOf(false)
    }

    AnimatedContent(showDetail, label = "basic") { targetScope ->
        if (!targetScope) {
            MainContent(
                modifier = modifier,
                onShowDetail = { showDetail = !showDetail },
                animatedVisibilityScope = this@AnimatedContent
            )
        } else {
            DetailsContent(
                modifier = modifier,
                onBack = { showDetail = !showDetail },
                animatedVisibilityScope = this@AnimatedContent
            )
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    onShowDetail: () -> Unit = {},
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Box(
        modifier = modifier
            .size(186.dp)
            .background(Lime, CircleShape)
            .clickable { onShowDetail() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.strawberry),
            contentDescription = "strawberry",
            modifier = Modifier
                .size(160.dp)
                .padding(10.dp)
        )
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailsContent(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)
        .background(
            Lime300, RoundedCornerShape(
                bottomStart = 30.dp, bottomEnd = 30.dp
            )
        )
        .clickable { onBack() }) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.strawberry),
            contentDescription = "strawberry",
            modifier = Modifier
                .size(200.dp)
                .padding(10.dp)
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Strawberry",
        modifier = Modifier.padding(horizontal = 10.dp),
        color = Color.White,
        fontSize = 21.sp
    )
    Text(
        text = "provides more vitamin C than an orange. " + "Strawberries also have minerals such as calcium, " + "iron, potassium, folate, and magnesium, along with antioxidants " + "called anthocyanins. Those are healthful plant compounds " + "that give strawberries their red color.",
        modifier = Modifier.padding(horizontal = 10.dp),
    )
}
