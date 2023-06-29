package com.guetcob.coursetable.config

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ProvidedValue
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.memberProperties

interface ConfigSet

fun ConfigSet.ToArray(): Array<ProvidedValue<*>> {
    return this::class.companionObjectInstance?.let { companion ->
        companion::class.run {
            memberProperties.map {
                @Suppress("UNCHECKED_CAST")
                (it.getter.call(companion) as ProvidableCompositionLocal<Any?>).provides(
                    it.getter.call(
                        this@ToArray
                    )
                )
            }.toTypedArray()
        }
    } ?: emptyArray()
}