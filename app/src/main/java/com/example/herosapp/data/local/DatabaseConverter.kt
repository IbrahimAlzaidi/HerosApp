package com.example.herosapp.data.local

import java.lang.StringBuilder

class DatabaseConverter {

    private val separator = ","

    fun convertListToString(list: List<String>) : String{
        val stringBuilder = StringBuilder()
        for (item in list){
            stringBuilder.append(item).append(separator)
        }
        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    fun convertStringToList(string: String) : List<String>{
    return string.split(separator)
    }
}