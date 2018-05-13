package com.kaiser.passwordmanager.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.kaiser.passwordmanager.R
import com.kaiser.passwordmanager.activity.utils.setKeyDefaultPrefs
import com.kaiser.passwordmanager.activity.utils.toast

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        fab.setOnClickListener { view ->
            var prefs = PreferenceManager.getDefaultSharedPreferences(this@LoginActivity)
            var pwd = prefs.getString("master_pwd", "")
            var msg = "Login Unsuccessful"

            if (txt_login_pin.text.toString().equals(pwd)) {
                msg = "Login done"
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            }

            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()


        }
    }
}
