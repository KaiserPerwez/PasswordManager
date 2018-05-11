package com.kaiser.passwordmanager.activity.utils

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast

fun Context.toast(msg: String = "NO msg") {
    android.widget.Toast.makeText(this, msg, android.widget.Toast.LENGTH_SHORT).show()
}

fun SharedPreferences.setKeyDefaultPrefs(key: String, value: String) {
    val editor = this.edit()
    editor.putString(key, value)
    editor.commit()
}