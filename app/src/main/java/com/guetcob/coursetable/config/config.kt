package com.guetcob.coursetable.config

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val systemBarColor =
    staticCompositionLocalOf<MutableState<ThemeToken<Color>?>> { throw NullPointerException() }

object Config {
    val SystemBarColor
        @Composable
        @ReadOnlyComposable
        get() = systemBarColor.current
}

@Composable
fun Config(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        systemBarColor provides remember { mutableStateOf(null) }
    ) {
        Language {
            Theme(content = content)
        }
    }
}