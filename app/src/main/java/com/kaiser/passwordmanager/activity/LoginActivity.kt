package com.kaiser.passwordmanager.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.kaiser.passwordmanager.DbWorkerThread
import com.kaiser.passwordmanager.R
import com.kaiser.passwordmanager.database.PasswordDatabase
import com.kaiser.passwordmanager.model.PasswordModel
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
