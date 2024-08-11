package com.su.io24_compose_experimental

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.su.io24_compose_experimental.adaptivelayouts.SampleListDetailPaneScaffold
import com.su.io24_compose_experimental.adaptivelayouts.SampleNavigationSuiteScaffold
import com.su.io24_compose_experimental.carousel.SampleCarousel
import com.su.io24_compose_experimental.contextualflow.SampleContextualFlowRow
import com.su.io24_compose_experimental.delightfului.SamplePager
import com.su.io24_compose_experimental.delightfului.SamplerNestedScroll
import com.su.io24_compose_experimental.htmltext.SampleHtmlText
import com.su.io24_compose_experimental.lazylistanims.SampleLazyListAnimatedItem
import com.su.io24_compose_experimental.pulltorefresh.SamplePullToRefresh
import com.su.io24_compose_experimental.segmentedbuttons.SampleSegmentedButtons
import com.su.io24_compose_experimental.sharedelements.SampleSharedElements
import com.su.io24_compose_experimental.ui.theme.Io24composeexperimentalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Io24composeexperimentalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = NavRoutes.NAV_HOME) {
                        composable(route = NavRoutes.NAV_HOME) {
                            HomeScreen(
                                Modifier.padding(innerPadding),
                                navToNestedScroll = { navController.navigate(NavRoutes.NAV_NESTEDSCROLL) },
                                navToNavigableSuiteScaffold = {
                                    navController.navigate(NavRoutes.NAV_SUITE_SCAFFOLD)
                                },
                                navToListDetail = {
                                    navController.navigate(NavRoutes.NAV_LISTDETAILPANESCAFFOLD)
                                },
                                navToPager = {
                                    navController.navigate(NavRoutes.NAV_PAGER)
                                },
                                navToSharedElements = {
                                    navController.navigate(NavRoutes.NAV_SHAREDELEMENT)
                                },
                                navToContextualFlow = {
                                    navController.navigate(NavRoutes.NAV_CONTEXTUALFLOW)
                                },
                                navToHtmlString = {
                                    navController.navigate(NavRoutes.NAV_HTMLTEXT)
                                },
                                navToLazyListAnimation = {
                                    navController.navigate(NavRoutes.NAV_LAZYLISTANIMATION)
                                },
                                navToCarousel = {
                                    navController.navigate(NavRoutes.NAV_CAROUSEL)
                                },
                                navToSegmentedButtons = {
                                    navController.navigate(NavRoutes.NAV_SEGMENTED_BUTTONS)
                                },
                                navToPullToRefresh = {
                                    navController.navigate(NavRoutes.NAV_PULLTOREFRESHBOX)
                                }
                            )
                        }
                        composable(NavRoutes.NAV_SUITE_SCAFFOLD) {
                            SampleNavigationSuiteScaffold()
                        }
                        composable(NavRoutes.NAV_LISTDETAILPANESCAFFOLD) {
                            SampleListDetailPaneScaffold()
                        }
                        composable(NavRoutes.NAV_PAGER) {
                            SamplePager()
                        }
                        composable(NavRoutes.NAV_SHAREDELEMENT) {
                            SampleSharedElements()
                        }
                        composable(NavRoutes.NAV_CONTEXTUALFLOW) {
                            SampleContextualFlowRow()
                        }
                        composable(NavRoutes.NAV_HTMLTEXT) {
                            SampleHtmlText()
                        }
                        composable(NavRoutes.NAV_LAZYLISTANIMATION) {
                            SampleLazyListAnimatedItem()
                        }
                        composable(NavRoutes.NAV_CAROUSEL) {
                            SampleCarousel()
                        }
                        composable(NavRoutes.NAV_SEGMENTED_BUTTONS) {
                            SampleSegmentedButtons()
                        }
                        composable(NavRoutes.NAV_PULLTOREFRESHBOX) {
                            SamplePullToRefresh()
                        }
                        composable(NavRoutes.NAV_NESTEDSCROLL) {
                            SamplerNestedScroll()
                        }
                    }
                }
            }
        }
    }
}


