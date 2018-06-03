package com.kaiser.passwordmanager.fragment


import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kaiser.passwordmanager.DbWorkerThread
import com.kaiser.passwordmanager.R
import com.kaiser.passwordmanager.activity.utils.toast
import com.kaiser.passwordmanager.adapter.PasswordListAdapter
import com.kaiser.passwordmanager.database.PasswordDatabase
import com.kaiser.passwordmanager.model.PasswordModel
import kotlinx.android.synthetic.main.bottom_dialog_modal_sheet.*
import kotlinx.android.synthetic.main.fragment_password_list.*

class PasswordListFragment : Fragment() {
    var dbPassword: PasswordDatabase? = null
    lateinit var dbWorkerThread: DbWorkerThread
    var listOfPasswordModel: List<PasswordModel>? = null
    var adapterPasswordListAdapter: PasswordListAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_password_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "My Secret Book"
        initialise() //database,worker thread,bottom show/hide listener
        initialiseAddCredentials()
    }

    private fun initialise() {
        activity?.applicationContext?.let {
            dbWorkerThread = DbWorkerThread(tag ?: "PasswordListFragment")
            dbWorkerThread.start()
            dbPassword = PasswordDatabase.getInstance(it)
            initialiseRecyclerView()

            tv_add_credentials?.setOnClickListener {
                val sheetBehavior = BottomSheetBehavior.from(bottom_sheet_root)
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    tv_add_credentials?.setText(getString(R.string.close))
                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    tv_add_credentials?.setText(getString(R.string.add_credentials))
                }


            }
        }
    }

    private fun initialiseRecyclerView() {
        /*Thread(Runnable {
            listOfPasswordModel = dbPassword?.passwordDao()?.getAll()
            listOfPasswordModel?.let {
                activity?.runOnUiThread(Runnable {
                    recyclerView.adapter = PasswordListAdapter(it, activity?.applicationContext)
                    recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)
                })
            }
        }).start()*/

        dbWorkerThread.postTask(Runnable {
            listOfPasswordModel = dbPassword?.passwordDao()?.getAll()
            listOfPasswordModel?.let {
                activity?.runOnUiThread(Runnable {
                    adapterPasswordListAdapter = PasswordListAdapter(it, activity?.applicationContext)
                    recyclerView?.adapter = adapterPasswordListAdapter
                    recyclerView?.layoutManager = LinearLayoutManager(activity?.applicationContext)
                                                //GridLayoutManager(activity?.applicationContext, 2)
                })
            }
        })


    }

    private fun initialiseAddCredentials() {
        btn_save_credentials?.setOnClickListener {
            var msg = when {
                txt_title?.text.toString().isBlank() -> "Title can't be blank"
                txt_username?.text.toString().isBlank() -> "Username can't be blank"
                txt_password?.text.toString().isBlank() -> "Password can't be blank"
                else -> "All good.Trying to save.."
            }
            activity?.toast(msg)

            if (msg.contains("blank")) return@setOnClickListener //missing data.Return back without saving

            //all good.Let's save the data
            var passwordModel = PasswordModel(title = txt_title?.text.toString(),
                    username = txt_username?.text.toString(),
                    password = txt_password?.text.toString())
            //using a new task/thread for queries, to avoid it on main thread as per "room" norms
            dbWorkerThread.postTask(Runnable {
                dbPassword?.passwordDao()?.insert(passwordModel)
                activity?.runOnUiThread {
                    adapterPasswordListAdapter?.addItem(passwordModel)
                    activity?.toast("Congrats!!. Data Saved")
                    btn_clear_credentials?.performClick()
                    tv_add_credentials?.performClick()
                }
            })
        }
        btn_clear_credentials?.setOnClickListener {
            txt_title?.text?.clear()
            txt_username?.text?.clear()
            txt_password?.text?.clear()
        }

    }

}
