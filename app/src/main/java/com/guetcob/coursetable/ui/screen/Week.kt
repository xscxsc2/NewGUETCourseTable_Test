package com.guetcob.coursetable.ui.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bloom.viewmodel.MainViewModel2
import com.example.kechengbiao.model.entity.WeekEntity
import com.guetcob.coursetable.config.Theme
import com.guetcob.coursetable.ui.componets.TopAppBar
import com.guetcob.coursetable.util.NumberConverter
import com.guetcob.coursetable.util.ToastUtil
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun Week(){

    var index by remember {
        mutableStateOf(0)
    }
    val context = LocalContext.current
    val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    val realweek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1
    val currentTime = getCurrentTime()

    var Jug = 0
    val weekday by remember {
        mutableStateOf(
            listOf(
//                WeekEntity("    $currentMonth\n   月"),
                WeekEntity(1),
                WeekEntity(2),
                WeekEntity(3),
                WeekEntity(4),
                WeekEntity(5),
                WeekEntity(6),
                WeekEntity(7)
            )
        )
    }

    Column(modifier = Modifier) {

        //标题栏
        TopAppBar (modifier = Modifier.padding(horizontal = 8.dp)) {


        }

        //月份及星期日期
        Row() {
            Text(text = "    $currentMonth\n   月")
            Spacer(modifier = Modifier.width(36.dp)) // 设置水平间隔
            Box(

            ){

                Row(modifier = Modifier.verticalScroll(rememberScrollState(),enabled = false)) {
                    weekday.forEach { item ->
                        val currentDate = LocalDate.now()
                        val currentWeekday = currentDate.dayOfWeek.value
                        val currentDay = currentDate.dayOfMonth

                        val targetWeekday = item.weekd.toInt()

                        val dayDifference = targetWeekday - currentWeekday
                        val targetDate = if (dayDifference >= 0) {
                            currentDate.plusDays(dayDifference.toLong())
                        } else {
                            currentDate.minusDays((-dayDifference).toLong())
                        }

                        val converter = NumberConverter()
                        var result = converter.convertToString2(item.weekd)

                        Text(
                            text = "$result        \n${targetDate.dayOfMonth}",
//                            fontWeight = FontWeight.Bold, //加粗
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(65.dp))
                    }

                }
            }



        }


        //具体布局
        Row(
        ) {
            //作息时间
            Column() {
                val Time2 = listOf(
                    "      1\n   08:25      \n   10.00      ",
                    "      2\n   10.25      \n   12.00      ",
                    "      3\n   14.30      \n   16.05      ",
                    "      4\n   16.30      \n   18.05      ",
                    "      晚\n   19.30      \n   20.15      "
                )
                Time2.forEachIndexed(){ index,item ->
                    Box(modifier = Modifier.size(width = 50.dp, height = 100.dp)){
                        Text(text = "$item", fontSize = 11.sp)
                    }
                    //分割线
                    if (currentTime >= "18:05" && index == 3){
                        Divider(modifier = Modifier
                            .width(60.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }else if(currentTime < "14.30"  && index == 1) {
                        Divider(modifier = Modifier
                            .width(60.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }
                }
            }


            //周一
            Column() {
                var textClicked = false
                val temp = listOf(
                    "一一一一一一一一一一一一一一一五五五五五五五五五五五五五五五",
                    "二二二二二二二二二二二二二二二五五五五五五五五五五五五五五五",
                    "三三三三三三三三三三三三三三三五五五五五五五五五五五五五五五",
                    "四四四四四四四四四四四四四四四五五五五五五五五五五五五五五五",
                    "五五五五五五五五五五五五五五五五五五五五五五五五五五五五五五",
                )
                temp.forEachIndexed(){  index,item ->

                  Box(
                      modifier = Modifier
                          .size(width = 50.dp, height = 100.dp)
                          .clip(RoundedCornerShape(5.dp))
                          .background(Theme.Main.BackgroundColor)
                  ){
                        Text(
                            text = "$item",
                            fontSize = 11.sp,
                            modifier = Modifier.clickable {
                            textClicked = true
                        })
                      if(textClicked) {
                            LaunchedEffect(Unit ){
                                ToastUtil.show(context,"1123")
                            }

                            textClicked = false
                        }
//                        Spacer(modifier = Modifier.height(34.dp))
                    }
                    //分割线
                    if (currentTime >= "18:05" && index == 3){
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }else if(currentTime < "14.30"  && index == 1) {
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }

                }
            }
//            Spacer(modifier = Modifier.width(32.dp))
            //周二
            Column() {
                var textClicked by remember { mutableStateOf(false) }
                val temp = listOf(
                    "一一一一一一一一一一一一一一一五五五五五五五五五五五五五五五",
                    "二二二二二二二二二二二二二二二五五五五五五五五五五五五五五五",
                    "三三三三三三三三三三三三三三三五五五五五五五五五五五五五五五",
                    "四四四四四四四四四四四四四四四五五五五五五五五五五五五五五五",
                    "五五五五五五五五五五五五五五五五五五五五五五五五五五五五五五",
                )
                temp.forEachIndexed(){  index,item ->
                    if (currentTime < "14.30"  && index == 1){

                    }
                    Box(modifier = Modifier.size(width = 50.dp, height = 100.dp)){
                        Text(
                            text = "$item",
                            fontSize = 11.sp,
                            modifier = Modifier.clickable {
                                textClicked = true
                            })
                        if(textClicked) {
                            LaunchedEffect(Unit ){
                                //ToastUtil.show(context,"1123")
                            }
                            textClicked = false
                        }
//                        Spacer(modifier = Modifier.height(34.dp))
                    }

                    //分割线
                    if (currentTime >= "18:05" && index == 3){
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }else if(currentTime < "14.30"  && index == 1) {
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }
                }
            }
//            Spacer(modifier = Modifier.width(32.dp))
            //周三
            Column() {
                var textClicked by remember { mutableStateOf(false) }
                val temp = listOf(
                    "一一一一一一一一一一一一一一一五五五五五五五五五五五五五五五",
                    "二二二二二二二二二二二二二二二五五五五五五五五五五五五五五五",
                    "三三三三三三三三三三三三三三三五五五五五五五五五五五五五五五",
                    "四四四四四四四四四四四四四四四五五五五五五五五五五五五五五五",
                    "五五五五五五五五五五五五五五五五五五五五五五五五五五五五五五",
                )
                temp.forEachIndexed(){  index,item ->
                    Box(modifier = Modifier.size(width = 50.dp, height = 100.dp)){
                        Text(
                            text = "$item",
                            fontSize = 11.sp,
                            modifier = Modifier.clickable {
                                textClicked = true
                            })
                        if(textClicked) {
                            LaunchedEffect(Unit ){
                                //ToastUtil.show(context,"1123")
                            }
                            textClicked = false
                        }
//                        Spacer(modifier = Modifier.height(34.dp))
                    }

                    //分割线
                    if (currentTime >= "18:05" && index == 3){
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }else if(currentTime < "14.30"  && index == 1) {
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }
                }
            }
//            Spacer(modifier = Modifier.width(38.dp))
            //周四
            Column() {
                var textClicked by remember { mutableStateOf(false) }
                val temp = listOf(
                    "一一一一一一一一一一一一一一一五五五五五五五五五五五五五五五",
                    "二二二二二二二二二二二二二二二五五五五五五五五五五五五五五五",
                    "三三三三三三三三三三三三三三三五五五五五五五五五五五五五五五",
                    "四四四四四四四四四四四四四四四五五五五五五五五五五五五五五五",
                    "五五五五五五五五五五五五五五五五五五五五五五五五五五五五五五",
                )
                temp.forEachIndexed(){  index,item ->
                    Box(modifier = Modifier.size(width = 50.dp, height = 100.dp)){
                        Text(
                            text = "$item",
                            fontSize = 11.sp,
                            modifier = Modifier.clickable {
                                textClicked = true
                            })
                        if(textClicked) {
                            LaunchedEffect(Unit ){
                                //ToastUtil.show(context,"1123")
                            }
                            textClicked = false
                        }
//                        Spacer(modifier = Modifier.height(34.dp))
                    }

                    //分割线
                    if (currentTime >= "18:05" && index == 3){
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }else if(currentTime < "14.30"  && index == 1) {
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }
                }
            }
//            Spacer(modifier = Modifier.width(38.dp))
            //周五
            Column() {
                var textClicked by remember { mutableStateOf(false) }
                val temp = listOf(
                    "一一一一一一一一一一一一一一一五五五五五五五五五五五五五五五",
                    "二二二二二二二二二二二二二二二五五五五五五五五五五五五五五五",
                    "三三三三三三三三三三三三三三三五五五五五五五五五五五五五五五",
                    "四四四四四四四四四四四四四四四五五五五五五五五五五五五五五五",
                    "五五五五五五五五五五五五五五五五五五五五五五五五五五五五五五",
                )
                temp.forEachIndexed(){  index,item ->
                    Box(modifier = Modifier.size(width = 50.dp, height = 100.dp)){
                        Text(
                            text = "$item",
                            fontSize = 11.sp,
                            modifier = Modifier.clickable {
                                textClicked = true
                            })
                        if(textClicked) {
                            LaunchedEffect(Unit ){
                                //ToastUtil.show(context,"1123")
                            }
                            textClicked = false
                        }
//                        Spacer(modifier = Modifier.height(34.dp))
                    }

                    //分割线
                    if (currentTime >= "18:05" && index == 3){
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }else if(currentTime < "14.30"  && index == 1) {
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }
                }
            }
//            Spacer(modifier = Modifier.width(38.dp))
            //周六
            Column() {
                var textClicked by remember { mutableStateOf(false) }
                val temp = listOf(
                    "一一一一一一一一一一一一一一一五五五五五五五五五五五五五五五",
                    "二二二二二二二二二二二二二二二五五五五五五五五五五五五五五五",
                    "三三三三三三三三三三三三三三三五五五五五五五五五五五五五五五",
                    "四四四四四四四四四四四四四四四五五五五五五五五五五五五五五五",
                    "五五五五五五五五五五五五五五五五五五五五五五五五五五五五五五",
                )
                temp.forEachIndexed(){  index,item ->
                    Box(modifier = Modifier.size(width = 50.dp, height = 100.dp)){
                        Text(
                            text = "$item",
                            fontSize = 11.sp,
                            modifier = Modifier.clickable {
                                textClicked = true
                            })
                        if(textClicked) {
                            LaunchedEffect(Unit ){
                                //ToastUtil.show(context,"1123")
                            }
                            textClicked = false
                        }
//                        Spacer(modifier = Modifier.height(34.dp))
                    }

                    //分割线
                    if (currentTime >= "18:05" && index == 3){
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }else if(currentTime < "14.30"  && index == 1) {
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }
                }
            }
//            Spacer(modifier = Modifier.width(38.dp))
            //周日
            Column() {
                var textClicked by remember { mutableStateOf(false) }
                val temp = listOf(
                    "一一一一一一一一一一一一一一一五五五五五五五五五五五五五五五",
                    "二二二二二二二二二二二二二二二五五五五五五五五五五五五五五五",
                    "三三三三三三三三三三三三三三三五五五五五五五五五五五五五五五",
                    "四四四四四四四四四四四四四四四五五五五五五五五五五五五五五五",
                    "五五五五五五五五五五五五五五五五五五五五五五五五五五五五五五",
                )
                temp.forEachIndexed(){  index,item ->
                    Box(modifier = Modifier.size(width = 50.dp, height = 100.dp)){
                        Text(
                            text = "$item",
                            fontSize = 11.sp,
                            modifier = Modifier.clickable {
                                textClicked = true
                            })
                        if(textClicked) {
                            LaunchedEffect(Unit ){
                                //ToastUtil.show(context,"1123")
                            }
                            textClicked = false
                        }
//                        Spacer(modifier = Modifier.height(34.dp))
                    }

                    //分割线
                    if (currentTime >= "18:05" && index == 3){
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }else if(currentTime < "14.30"  && index == 1) {
                        Divider(modifier = Modifier
                            .width(50.dp)
                            .padding(vertical = 8.dp), color = Color.Blue)
                    }
                }
            }

        }




    }
}


// 获取当前时间的函数示例（需要根据您的实际代码进行实现）
@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentTime(): String {
    // 在这里获取并返回当前时间，例如："HH:mm" 格式
    // 示例（使用当前系统时间）：
    val currentTime = LocalTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    return currentTime.format(formatter)
}