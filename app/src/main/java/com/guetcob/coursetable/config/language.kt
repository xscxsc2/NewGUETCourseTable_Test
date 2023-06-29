package com.guetcob.coursetable.config

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.lifecycle.MutableLiveData
import java.util.Locale

object Language {
    object Main {
        val PageContent
            @Composable
            @ReadOnlyComposable
            get() = (String.HelloWorld.current as PlainString).Str
        val PageNumber
            @Composable
            @ReadOnlyComposable
            get() = String.PageN.current as StringPageN
    }
}

val CurrentLocale = MutableLiveData<Locale>()

@Composable
fun Language(
    content: @Composable () -> Unit
) {
    val currentLocale by CurrentLocale.observeAsState(Locale.getDefault())
    val newLocale by remember {
        derivedStateOf(structuralEqualityPolicy()) { currentLocale }
    }
    CompositionLocalProvider(
        *newLocale.let { l ->
            when {
                l.toLanguageTag() == Locale.SIMPLIFIED_CHINESE.toLanguageTag() -> ZHCNStringConfig()
                Locale(l.language).language == Locale.ENGLISH.language -> ENStringConfig()
                else -> ZHCNStringConfig()
            }
        }
    ) {
        content()
    }
}