package com.guetcob.coursetable.config

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color as ComposeColor

private fun compositionLocalColor(): ProvidableCompositionLocal<ComposeColor> {
    return compositionLocalOf { throw NullPointerException() }
}

open class Color<T>(
    val LightPink: T,
    val LightBlue: T,
    val LightGreen: T,
    val LightYellow: T,
    val LightPurple: T,
    val LightCyan: T,
    val LightOrange: T,
    val LightIndigo: T,
    //
    val DarkPink: T,
    val DarkBlue: T,
    val DarkGreen: T,
    val DarkYellow: T,
    val DarkPurple: T,
    val DarkCyan: T,
    val DarkOrange: T,
    val DarkIndigo: T,
    //
    val PurePink: T,
    val PureBlue: T,
    val PureGreen: T,
    val PureYellow: T,
    val PurePurple: T,
    val PureCyan: T,
    val PureOrange: T,
    val PureIndigo: T,
    //
    val AAFLightGreen: T,
    val AAFDarkGreen: T,
    val AAFPureGreen: T,
    val AAFButtonGreen: T,
    val AAFButtonWhite: T,
    val AAFButtonShadowGrey: T,
    //
    val LogoCyan: T,
    //
    val SuccessGreen: T,
    //
    val FailureRed: T,
    //
    val WarningYellow: T,
    //
    val SnackBarChocolate: T,
    val SnackBarIceCream: T,
    //
    val SignInProgressBarGreen: T,
    val SignInLogoBlue: T,
    //
    val GlobalBackground: T,
    val GlobalBackground90: T,
    val GlobalBackground40: T,
    //
    val GlobalGrey: T,
    val GlobalTextTitle: T,
    val GlobalTextBigAndFlat: T,
    val GlobalTextNormal: T,
    val GlobalTextSecond: T,
    val GlobalTextThird: T,
    val GlobalShadow: T,
) : ConfigSet {
    companion object : Color<ProvidableCompositionLocal<ComposeColor>>(
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
        compositionLocalColor(),
    )
}

fun LightColorConfig(): Array<ProvidedValue<*>> = Color(
    LightPink = ComposeColor(0xFFffd2dc),
    LightBlue = ComposeColor(0xFFb6e9ff),
    LightGreen = ComposeColor(0xFFc8f1ce),
    LightYellow = ComposeColor(0xFFffefb6),
    LightPurple = ComposeColor(0xFFe0cbf3),
    LightCyan = ComposeColor(0xFFb5f3f3),
    LightOrange = ComposeColor(0xFFffd3b4),
    LightIndigo = ComposeColor(0xFFc7dcff),
    //
    DarkPink = ComposeColor(0xFFff4e6f),
    DarkBlue = ComposeColor(0xFF0083b9),
    DarkGreen = ComposeColor(0xFF2f8d45),
    DarkYellow = ComposeColor(0xFF9b8000),
    DarkPurple = ComposeColor(0xFF894bb0),
    DarkCyan = ComposeColor(0xFF008686),
    DarkOrange = ComposeColor(0xFFda5816),
    DarkIndigo = ComposeColor(0xFF3e6ecb),
    //
    PurePink = ComposeColor(0xFFff8e9e),
    PureBlue = ComposeColor(0xFF4ebafa),
    PureGreen = ComposeColor(0xFF78cd82),
    PureYellow = ComposeColor(0xFFffb13b),
    PurePurple = ComposeColor(0xFFc28df0),
    PureCyan = ComposeColor(0xFF57c7c7),
    PureOrange = ComposeColor(0xFFffa160),
    PureIndigo = ComposeColor(0xFF79a1ec),
    //
    AAFLightGreen = ComposeColor(0xFFdaefdf),
    AAFDarkGreen = ComposeColor(0xFF0c1513),
    AAFPureGreen = ComposeColor(0xFF549479),
    AAFButtonGreen = ComposeColor(0xFF57b07f),
    AAFButtonWhite = ComposeColor(0xFFffffff),
    AAFButtonShadowGrey = ComposeColor(0xFFa8a8a8),
    //
    LogoCyan = ComposeColor(0xFF78e8dd),
    //
    SuccessGreen = ComposeColor(0xFF61e06b),
    //
    FailureRed = ComposeColor(0xFFff6565),
    //
    WarningYellow = ComposeColor(0xFFffdd33),
    //
    SnackBarChocolate = ComposeColor(0xFF333333),
    SnackBarIceCream = ComposeColor(0xFFfefefe),
    //
    SignInProgressBarGreen = ComposeColor(0xFFc8efcd),
    SignInLogoBlue = ComposeColor(0xFF89d3f5),
    //
    GlobalBackground = ComposeColor(0xFFfdfdfd),
    GlobalBackground90 = ComposeColor(0xE6fdfdfd),
    GlobalBackground40 = ComposeColor(0x66fdfdfd),
    //
    GlobalGrey = ComposeColor(0xFFe7e7e7),
    GlobalTextTitle = ComposeColor(0xFF000000),
    GlobalTextBigAndFlat = ComposeColor(0xFF595959),
    GlobalTextNormal = ComposeColor(0xFF212121),
    GlobalTextSecond = ComposeColor(0xFF676767),
    GlobalTextThird = ComposeColor(0xFFababab),
    GlobalShadow = ComposeColor(0x44000000),
).ToArray()

fun DarkColorConfig(): Array<ProvidedValue<*>> = Color(
    LightPink = ComposeColor(0xFFffd2dc),
    LightBlue = ComposeColor(0xFFb6e9ff),
    LightGreen = ComposeColor(0xFFc8f1ce),
    LightYellow = ComposeColor(0xFFffefb6),
    LightPurple = ComposeColor(0xFFe0cbf3),
    LightCyan = ComposeColor(0xFFb5f3f3),
    LightOrange = ComposeColor(0xFFffd3b4),
    LightIndigo = ComposeColor(0xFFc7dcff),
    //
    DarkPink = ComposeColor(0xFFff4e6f),
    DarkBlue = ComposeColor(0xFF0083b9),
    DarkGreen = ComposeColor(0xFF2f8d45),
    DarkYellow = ComposeColor(0xFF9b8000),
    DarkPurple = ComposeColor(0xFF894bb0),
    DarkCyan = ComposeColor(0xFF008686),
    DarkOrange = ComposeColor(0xFFda5816),
    DarkIndigo = ComposeColor(0xFF3e6ecb),
    //
    PurePink = ComposeColor(0xFFff8e9e),
    PureBlue = ComposeColor(0xFF4ebafa),
    PureGreen = ComposeColor(0xFF78cd82),
    PureYellow = ComposeColor(0xFFffb13b),
    PurePurple = ComposeColor(0xFFc28df0),
    PureCyan = ComposeColor(0xFF57c7c7),
    PureOrange = ComposeColor(0xFFffa160),
    PureIndigo = ComposeColor(0xFF79a1ec),
    //
    AAFLightGreen = ComposeColor(0xFFdaefdf),
    AAFDarkGreen = ComposeColor(0xFF0c1513),
    AAFPureGreen = ComposeColor(0xFF549479),
    AAFButtonGreen = ComposeColor(0xFF57b07f),
    AAFButtonWhite = ComposeColor(0xFFffffff),
    AAFButtonShadowGrey = ComposeColor(0xFFa8a8a8),
    //
    LogoCyan = ComposeColor(0xFF78e8dd),
    //
    SuccessGreen = ComposeColor(0xFF61e06b),
    //
    FailureRed = ComposeColor(0xFFff6565),
    //
    WarningYellow = ComposeColor(0xFFffdd33),
    //
    SnackBarChocolate = ComposeColor(0xFF333333),
    SnackBarIceCream = ComposeColor(0xFFfefefe),
    //
    SignInProgressBarGreen = ComposeColor(0xFFc8efcd),
    SignInLogoBlue = ComposeColor(0xFF89d3f5),
    //
    GlobalBackground = ComposeColor(0xFFfdfdfd),
    GlobalBackground90 = ComposeColor(0xE6fdfdfd),
    GlobalBackground40 = ComposeColor(0x66fdfdfd),
    //
    GlobalGrey = ComposeColor(0xFFe7e7e7),
    GlobalTextTitle = ComposeColor(0xFF000000),
    GlobalTextBigAndFlat = ComposeColor(0xFF595959),
    GlobalTextNormal = ComposeColor(0xFF212121),
    GlobalTextSecond = ComposeColor(0xFF676767),
    GlobalTextThird = ComposeColor(0xFFababab),
    GlobalShadow = ComposeColor(0x44000000),
).ToArray()