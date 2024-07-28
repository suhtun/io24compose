package com.su.io24_compose_experimental.adaptivelayouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass

/*
For WindowWidthSizeInfo: currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
Default: NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(currentWindowAdaptiveInfo())
* */

@Preview
@Composable
fun SampleNavigationSuiteScaffold(modifier: Modifier = Modifier) {

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    val currentWindowWidthSize = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            Screens.entries.forEachIndexed { index, screens ->
                item(selected = index == selectedIndex,
                    onClick = { selectedIndex = index },
                    icon = { Icon(imageVector = screens.icon, contentDescription = screens.title) },
                    label = { Text(text = screens.title) })
            }
        },
        layoutType =
        if (currentWindowWidthSize == WindowWidthSizeClass.EXPANDED)
            NavigationSuiteType.NavigationDrawer
        else NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(currentWindowAdaptiveInfo())
    )
    {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (selectedIndex) {
                0 -> Text(text = "Home")
                1 -> Text(text = "Profile")
                2 -> Text(text = "Setting")
            }
        }
    }
}

enum class Screens(val icon: ImageVector, val title: String) {
    HOME(Icons.Default.Home, "Home"),
    PROFILE(Icons.Default.Person, "Profile"),
    SETTING(Icons.Default.Settings, "Setting")
}