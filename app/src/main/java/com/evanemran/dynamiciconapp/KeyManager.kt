package com.evanemran.dynamiciconapp

import android.content.Context
import android.content.SharedPreferences

class KeyManager(context: Context) {

    companion object {
        private const val PREF_NAME = "ApiPreferences"
        private const val ALIAS_KEY = "alias"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var selectedAlias: String?
        get() = sharedPreferences.getString(ALIAS_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(ALIAS_KEY, value).apply()
        }

    fun clearApiKey() {
        sharedPreferences.edit().remove(ALIAS_KEY).apply()
    }
}