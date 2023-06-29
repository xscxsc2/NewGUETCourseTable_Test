package com.guetcob.coursetable.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.guetcob.coursetable.config.Theme
import com.guetcob.coursetable.entity.NavigationItem
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp

@Composable
fun MainFrame() {
    val navigationItems = listOf(
        NavigationItem(title = "日课表\n", icon = null),
        NavigationItem(title = "周课表\n", icon = null),
        NavigationItem(title = "更多\n", icon = null),
    )

    var currentNavigationIndex by remember {
        mutableStateOf(0)
    }

    val selectedPage = remember { mutableStateOf(0) }

    Scaffold(
        containerColor = Theme.Main.BackgroundColor,
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.height(55.dp),
                backgroundColor = Theme.Main.BackgroundColor,
            ) {
                navigationItems.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = {

                        },
                        label = {
                            Text(
                                text = item.title,
                            )
                        },
                        selected = currentNavigationIndex == index,
                        onClick = {
                            currentNavigationIndex = index
                            selectedPage.value = index
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)

        ) {
            when (currentNavigationIndex) {
                0 -> { /* 第一个导航项的内容 */}
                1 -> Week()
                2 -> { /* 第三个导航项的内容 */}
            }
        }
    }



}

