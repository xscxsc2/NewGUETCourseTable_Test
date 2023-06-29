package com.guetcob.coursetable.test

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding

import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.guetcob.coursetable.util.ToastUtil


//@Preview
//@Composable
//fun ClickableTextExample() {
//    var textClicked by remember { mutableStateOf(false) }
//    val context = LocalContext.current
//
//    Text(
//        text = "Click me!",
//        modifier = Modifier.clickable {
//            textClicked = true
//        }
//    )
//
//    if (textClicked) {
//        LaunchedEffect(Unit) {
//            Toast.makeText(context,"123",Toast.LENGTH_SHORT)
//            textClicked = false
//        }
//    }
//}
@Preview
@Composable
fun ClickableTextExample() {
    var textClicked by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Text(
        text = "Click me!",
        modifier = Modifier.clickable {
            textClicked = true
        }
    )

    if(textClicked) {
        Text("Text clicked!")
        ToastUtil.show(context,"1123")
        textClicked = false
    }
}