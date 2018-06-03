package com.kaiser.passwordmanager.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.text.method.Touch
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.kaiser.passwordmanager.R
import com.kaiser.passwordmanager.activity.utils.toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val prefs = PreferenceManager.getDefaultSharedPreferences(this@LoginActivity)
        val pwd = prefs.getString("master_pwd", "1111")

        btn_login?.setOnClickListener {
            if (txt_login_pin?.text.isNullOrBlank()) {
                toast("PIN Must be of at least 4 digits")
                return@setOnClickListener
            }
            it.isEnabled=false
            loading_dots?.visibility = View.VISIBLE

            Handler().postDelayed(Runnable {
                runOnUiThread {
                    if (txt_login_pin?.text.toString().equals(pwd)) {
                        toast("You are identified.\n Welcome!!")
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    } else {
                        toast("Couldn't verify. Is that really YOU??")
                    }
                    loading_dots?.visibility = View.GONE
                    it.isEnabled=true
                }
            }, 4000)
        }
    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        txt_login_pin?.clearFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
        return super.dispatchTouchEvent(ev)
    }
}
