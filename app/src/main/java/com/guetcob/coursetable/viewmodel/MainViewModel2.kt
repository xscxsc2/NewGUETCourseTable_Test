package com.example.bloom.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kechengbiao.model.entity.OneDayTime
import com.example.kechengbiao.model.entity.WeekEntity
import com.guetcob.coursetable.entity.NavigationItem
import com.guetcob.coursetable.entity.WeekCC
import java.util.Calendar


class MainViewModel2 : ViewModel(){
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

//    val weekday by mutableStateOf(
//        listOf(
////            WeekEntity(" $currentMonth\n月"),
//            WeekEntity("一"),
//            WeekEntity("二"),
//            WeekEntity("三"),
//            WeekEntity("四"),
//            WeekEntity("五"),
//            WeekEntity("六"),
//            WeekEntity("日")
//        )
//    )
    var weekIndex by mutableStateOf(0)
        private set
    fun updateWeekIndex(index: Int){
        weekIndex = index
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val  Time by mutableStateOf(
        listOf(
            OneDayTime("08:25\n10.00"),
            OneDayTime("10.25\n12.00"),
            OneDayTime("14.30\n16.05"),
            OneDayTime("16.30\n18.05"),
            OneDayTime("19.30\n20.15"),

        )
    )
    var timeIndex by mutableStateOf(0)
        private set
    fun updateTimeIndex(index: Int){
        timeIndex = index
    }
    val Time2 = listOf("08:25\n10.00", "10.25\n12.00", "14.30\n16.05","16.30\n18.05","19.30\n20.15")
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val Bottomitems by mutableStateOf(
        listOf(
            NavigationItem(title = "日课表\n", icon = null),
            NavigationItem(title = "周课表\n", icon = null),
            NavigationItem(title = "更多\n", icon = null),
        )
    )
    var BottomitemsIndex by mutableStateOf(0)
        private set
    fun updateBottomitemsIndex(index: Int){
        BottomitemsIndex = index
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    val Week = listOf(
        WeekCC("周一"),
        WeekCC("周二"),
        WeekCC("周三"),
        WeekCC("周四"),
        WeekCC("周五"),
        WeekCC("周六"),
        WeekCC("周日")
    )





}


