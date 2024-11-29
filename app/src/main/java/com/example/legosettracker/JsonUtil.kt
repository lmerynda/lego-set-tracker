package com.example.legosettracker

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonUtil {
    private val gson = Gson()

    fun <T> toJson(obj: T): String {
        return gson.toJson(obj)
    }

    fun <T> fromJson(json: String, typeToken: TypeToken<T>): T {
        return gson.fromJson(json, typeToken.type)
    }
}