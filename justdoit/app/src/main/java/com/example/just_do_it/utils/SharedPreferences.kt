package com.example.just_do_it.utils

import android.content.Context

class SharedPreferences(contexto: Context) {
    private val sharedPreferences =
        contexto.getSharedPreferences("app", Context.MODE_PRIVATE)

    fun storeId(key: String, value: Long){
        sharedPreferences.edit().putLong(key,value).apply()
    }
    fun getId(key:String) :Long{

        return sharedPreferences.getLong(key, 0)
    }
}