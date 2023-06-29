package com.guetcob.coursetable.config

import androidx.activity.ComponentActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import com.guetcob.coursetable.util.SetSystemBarColor

@JvmInline
value class ThemeToken<T>(val token: ProvidableCompositionLocal<T>)

object ThemeTokens {
    object Main {
        val BackgroundColor = ThemeToken(Color.LightYellow)
        val TextColor = ThemeToken(Color.DarkYellow)
    }
}

object Theme {
    object Main {
        val BackgroundColor
            @Composable
            @ReadOnlyComposable
            get() = ThemeTokens.Main.BackgroundColor.token.current
        val TextColor
            @Composable
            @ReadOnlyComposable
            get() = ThemeTokens.Main.TextColor.token.current
    }
}

@Composable
fun Theme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        *when {
            isSystemInDarkTheme() -> DarkColorConfig()
            else -> LightColorConfig()
        }
    ) {
        Config.SystemBarColor.value?.let { updateSystemBarColor(barColor = it) }
        MaterialTheme(content = content)
    }
}

@Composable
private fun updateSystemBarColor(barColor: ThemeToken<androidx.compose.ui.graphics.Color>) {
    (LocalContext.current as? ComponentActivity)?.window?.SetSystemBarColor(barColor.token.current)
}