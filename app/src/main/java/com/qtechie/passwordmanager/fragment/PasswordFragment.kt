package com.qtechie.passwordmanager.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.qtechie.passwordmanager.R
import com.qtechie.passwordmanager.adapter.PasswordRecyclerViewAdapter
import com.qtechie.passwordmanager.model.PasswordModel

import java.util.ArrayList

import butterknife.BindView
import butterknife.ButterKnife

/**
 * A simple [Fragment] subclass.
 * Use the [PasswordFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PasswordFragment : Fragment() {

    @BindView(R.id.recyclerView)
    internal var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_password, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        ButterKnife.bind(this, view!!)
        val passwordModelList = ArrayList<PasswordModel>()

        val passwordRecyclerViewAdapter = PasswordRecyclerViewAdapter(passwordModelList)
        val mLayoutManager = LinearLayoutManager(activity.applicationContext)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        recyclerView!!.adapter = passwordRecyclerViewAdapter

        loadItems(passwordModelList)
        passwordRecyclerViewAdapter.notifyDataSetChanged()
    }

    private fun loadItems(passwordModelList: MutableList<PasswordModel>) {
        passwordModelList.add(PasswordModel("", "my title", "", "", "", "", "", ""))
        passwordModelList.add(PasswordModel("", "my title2", "", "", "", "", "", ""))
        passwordModelList.add(PasswordModel("", "my title3", "", "", "", "", "", ""))
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {

        fun newInstance(): PasswordFragment {
            return PasswordFragment()
        }
    }
}// Required empty public constructor
