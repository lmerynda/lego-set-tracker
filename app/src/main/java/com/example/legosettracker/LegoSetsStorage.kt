package com.example.legosettracker

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LegoSetsStorage(private val preferences: SharedPreferences) {
    private var cachedLegoSets: MutableMap<String, LegoSet>? = null

    fun getLegoSets(): List<LegoSet> {
        if (cachedLegoSets == null) {
            loadFromPreferences()
        }
        return cachedLegoSets?.values?.toList() ?: emptyList()
    }

    fun getLegoSetByTitle(title: String): LegoSet? {
        if (cachedLegoSets == null) {
            loadFromPreferences()
        }
        return cachedLegoSets?.get(title)
    }

    fun saveLegoSet(legoSet: LegoSet) {
        if (cachedLegoSets == null) {
            loadFromPreferences()
        }

        cachedLegoSets?.put(legoSet.title, legoSet)
        persistCache()
    }

    private fun loadFromPreferences() {
        val json = preferences.getString("lego_sets_key", "{}")
        val type = object : TypeToken<Map<String, LegoSet>>() {}.type
        cachedLegoSets = Gson().fromJson(json, type) ?: mutableMapOf()
        if(cachedLegoSets?.isEmpty() == true) {
            cachedLegoSets = loadInitialData()
        }
    }

    private fun persistCache() {
        preferences.edit()
            .putString("lego_sets_key", Gson().toJson(cachedLegoSets))
            .apply()
    }

    private fun loadInitialData(): MutableMap<String, LegoSet> {
        val initialData = LegoSetsData.legoSets
        val data = initialData.associateBy { it.title }.toMutableMap()

        return data;
    }
}