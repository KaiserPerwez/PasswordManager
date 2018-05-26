package com.kaiser.passwordmanager.activity

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.kaiser.passwordmanager.R
import com.kaiser.passwordmanager.activity.utils.loadFragment
import com.kaiser.passwordmanager.activity.utils.toast
import com.kaiser.passwordmanager.fragment.ChangePasswordFragment
import com.kaiser.passwordmanager.fragment.PasswordListFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        loadFragment(R.id.frame_content, PasswordListFragment())
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    /* override fun onCreateOptionsMenu(menu: Menu): Boolean {
         // Inflate the menu; this adds items to the action bar if it is present.
         menuInflater.inflate(R.menu.main, menu)
         return true
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         // Handle action bar item clicks here. The action bar will
         // automatically handle clicks on the Home/Up button, so long
         // as you specify a parent activity in AndroidManifest.xml.
         when (item.itemId) {
             R.id.action_settings -> return true
             else -> return super.onOptionsItemSelected(item)
         }
     }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        lateinit var fragment: Fragment
        when (item.itemId) {
            R.id.nav_home -> {
                //toast("Loaded Home")
                title = "Home"
                fragment = PasswordListFragment()
            }
            R.id.nav_change_pwd -> {
                toast("Loaded Change Pwd")
                title = "Change Password"
                fragment = ChangePasswordFragment()
            }
            R.id.nav_share -> {
                toast("Loaded Share")
            }
            R.id.nav_feedback -> {
                toast("Loaded Feedback")
            }
            R.id.nav_about -> {
                toast("Loaded About")
            }
        }
        loadFragment(R.id.frame_content, fragment)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
