package com.kaiser.passwordmanager.activity.utils

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.SharedPreferences

fun Context?.toast(msg: String = "NO msg") {
    android.widget.Toast.makeText(this, msg, android.widget.Toast.LENGTH_SHORT).show()
}

fun SharedPreferences.setKeyDefaultPrefs(key: String, value: String) {
    val editor = this.edit()
    editor.putString(key, value)
    editor.apply()
}

fun Activity?.loadFragment(contentFrame: Int, fragment: Fragment) {
    this?.fragmentManager?.beginTransaction()?.replace(contentFrame, fragment)?.commit()
}
