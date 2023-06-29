package com.guetcob.coursetable.main

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.guetcob.coursetable.config.Config
import com.guetcob.coursetable.config.CurrentLocale
import com.guetcob.coursetable.config.Language
import com.guetcob.coursetable.config.Theme
import com.guetcob.coursetable.config.ThemeTokens
import com.guetcob.coursetable.ui.screen.MainFrame
import com.guetcob.coursetable.ui.screen.Week
import com.guetcob.coursetable.util.SetContent

@OptIn(ExperimentalFoundationApi::class)
@Composable
 fun pager() {
    Config.SystemBarColor.value = ThemeTokens.Main.BackgroundColor
    // Display 10 items
    val pagerState = rememberPagerState()
    HorizontalPager(
        pageCount = 3,
        state = pagerState
    ) {     page ->
        Surface(color = Theme.Main.BackgroundColor, modifier = Modifier.fillMaxSize()) {
            Column {
                Text(text = Language.Main.PageNumber.Format(1))

            }
        }
    }
}




@Preview
@Composable
private fun content() {
    pager()
}

class Main : ComponentActivity() {
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        CurrentLocale.value = newConfig.locales[0]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SetContent {
            content()
        }
    }
}