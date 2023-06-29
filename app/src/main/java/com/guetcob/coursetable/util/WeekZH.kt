package com.guetcob.coursetable.util

class NumberConverter {
    fun convertToString(number: String): Int {
        return when (number) {
            "一" -> 1
            "二" -> 2
            "三" -> 3
            "四" -> 4
            "五" -> 5
            "六" -> 6
            "日" -> 7
            else -> 99
        }
    }

    fun convertToString2(number: Int): String {
        return when (number) {
            1 -> "一"
             2 ->"二"
             3->"三"
             4->"四"
             5->"五"
             6->"六"
             7->"日"
            else -> "s"
        }
    }
}