package com.qtechie.passwordmanager


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.ContentFrameLayout
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.qtechie.passwordmanager.database.AppDatabase
import com.qtechie.passwordmanager.fragment.BottomSheetDialogAddPasswordFragment
import com.qtechie.passwordmanager.fragment.PasswordFragment
import com.qtechie.passwordmanager.model.PasswordModel
import com.qtechie.passwordmanager.utils.ConstUtils

import java.util.ArrayList

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {
    @BindView(R.id.content_frame)
    internal var contentFrameLayout: ContentFrameLayout? = null
    @BindView(R.id.toolbar)
    internal var toolbar: Toolbar? = null
    @BindView(R.id.fab)
    internal var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)
        toolbar!!.title = "No"
        setSupportActionBar(toolbar)

        loadPasswordListFragment()

        val database = AppDatabase.getDatabase(applicationContext)

        // cleanup for testing some initial data
        database.passwordDao().deleteAllPasswordModels()
        // add some data
        val passwordModels = database.passwordDao().allPasswordModels
        val model: PasswordModel
        if (passwordModels.size == 0) {
            val passwordModelList = ArrayList<PasswordModel>()
            passwordModelList.add(PasswordModel("", "my title", "", "", "", "", "", ""))
            passwordModelList.add(PasswordModel("", "my title2", "", "", "", "", "", ""))
            passwordModelList.add(PasswordModel("", "my title3", "", "", "", "", "", ""))
            database.passwordDao().addPassword(passwordModelList)
            model = database.passwordDao().allPasswordModels[0]
            Toast.makeText(this, model.id.toString(), Toast.LENGTH_SHORT).show()
        }


    }

    private fun loadPasswordListFragment() {
        val fragment = PasswordFragment.newInstance()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content_frame, fragment, ConstUtils.TAG_PASSWORD_FRAG)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "Name: " + item.title, Toast.LENGTH_SHORT).show()
        return true
    }

    @OnClick(R.id.fab)
    fun showDialogFragOnFabClick() {
        val bottomSheetDialogAddPasswordFragment = BottomSheetDialogAddPasswordFragment()
        bottomSheetDialogAddPasswordFragment.show(supportFragmentManager, "tag")
    }
}
