package com.guetcob.coursetable.ui.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guetcob.coursetable.config.ThemeTokens
import java.util.Calendar



@Composable
fun TopAppBar(modifier: Modifier = Modifier, content:@Composable () -> Unit){

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ){
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        Column() {
            Text(text = "$currentYear/$currentMonth/$currentDay")
            Text(text = "n天前同步",fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.width(230.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val lastWeekText = "上周"
            val nextWeekText = "下周"

            val firstTextClicked = remember { mutableStateOf(false) }
            val secondTextClicked = remember { mutableStateOf(false) }

            Row {
                Text(
                    text = lastWeekText,
                    modifier = Modifier
                        .clickable { firstTextClicked.value = true }
                        .padding(8.dp)
                )

                Text(
                    text = nextWeekText,
                    modifier = Modifier
                        .clickable { secondTextClicked.value = true }
                        .padding(8.dp)
                )
            }

            if (firstTextClicked.value) {
                // 执行第一个文本被点击后的操作
                // 在这里添加您的逻辑代码
                firstTextClicked.value = false // 重置点击状态
            }

            if (secondTextClicked.value) {
                // 执行第二个文本被点击后的操作
                // 在这里添加您的逻辑代码
                secondTextClicked.value = false // 重置点击状态
            }
        }

    }

}