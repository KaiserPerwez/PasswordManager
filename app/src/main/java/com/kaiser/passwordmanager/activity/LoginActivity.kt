package com.kaiser.passwordmanager.activity

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
        //setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            var prefs = PreferenceManager.getDefaultSharedPreferences(this@LoginActivity)
            var pwd = prefs.getString("master_pwd", "")
            var msg = "Login Unsuccessful"

            if (txt_login_pin.text.toString().equals(pwd))
                msg= "Login done"

            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()


        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_login, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/
}
