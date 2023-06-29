package com.guetcob.coursetable.config

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.compositionLocalOf

private fun compositionLocalString(): ProvidableCompositionLocal<StringResource> {
    return compositionLocalOf { throw NullPointerException() }
}

interface StringResource

@JvmInline
value class PlainString(val Str: kotlin.String) : StringResource

@JvmInline
value class StringPageN(private val str: kotlin.String) : StringResource {
    fun Format(n: Int) = str.format(n)
}

open class String<T>(
    val HelloWorld: T,
    val PageN: T,
) : ConfigSet {
    companion object : String<ProvidableCompositionLocal<StringResource>>(
        compositionLocalString(),
        compositionLocalString(),
    )
}

fun ENStringConfig(): Array<ProvidedValue<*>> = String(
    HelloWorld = PlainString("hello, world"),
    PageN = StringPageN("Page %d"),
).ToArray()

fun ZHCNStringConfig(): Array<ProvidedValue<*>> = String(
    HelloWorld = PlainString("你好，世界"),
    PageN = StringPageN("第 %d 页"),
).ToArray()