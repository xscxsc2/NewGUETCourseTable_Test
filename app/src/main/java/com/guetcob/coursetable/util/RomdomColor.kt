package com.guetcob.coursetable.util

import androidx.compose.ui.graphics.Color  as ComposeColor
import com.guetcob.coursetable.config.DarkColorConfig
import com.guetcob.coursetable.config.LightColorConfig
import com.guetcob.coursetable.config.Theme
import kotlin.random.Random

//已知适用于Box

// 定义一个函数来随机选择颜色
fun getRandomColor(): ComposeColor {
    val lightColors = LightColorConfig()
    val darkColors = DarkColorConfig()

    val randomIndex = Random.nextInt(lightColors.size)

    // 随机选择浅色或深色主题
    val colors = if (Random.nextBoolean()) lightColors else darkColors

    return colors[randomIndex] as ComposeColor
}

// 调用函数获取随机颜色
val randomColor = getRandomColor()