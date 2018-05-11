package com.qtechie.passwordmanager.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.qtechie.passwordmanager.R
import com.qtechie.passwordmanager.model.PasswordModel

import java.util.ArrayList

import butterknife.BindView
import butterknife.ButterKnife

/**
 * Created by Admin on 03-03-2018.
 */

class PasswordRecyclerViewAdapter(passwordModelList: List<PasswordModel>) : RecyclerView.Adapter<PasswordRecyclerViewAdapter.PasswordViewHolder>() {
    internal var passwordModelList: List<PasswordModel> = ArrayList()

    init {
        this.passwordModelList = passwordModelList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasswordViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.pwd_list_row, parent, false)
        return PasswordViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: PasswordViewHolder, position: Int) {
        val model = passwordModelList[position]
        holder.title.text = model.title
    }

    override fun getItemCount(): Int {
        return passwordModelList.size
    }

    inner class PasswordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.tV_category)
        var category: TextView? = null

        @BindView(R.id.tV_title)
        var title: TextView

        @BindView(R.id.tV_username)
        var username: TextView? = null
        @BindView(R.id.tV_pwd)
        var password: TextView? = null
        @BindView(R.id.tV_ques1)
        var security_ques1: TextView? = null
        @BindView(R.id.tV_ques2)
        var security_ques2: TextView? = null
        @BindView(R.id.tV_ans1)
        var security_ans1: TextView? = null
        @BindView(R.id.tV_ans2)
        var security_ans2: TextView? = null

        init {
            ButterKnife.bind(this, itemView)
            title = itemView.findViewById(R.id.tV_title)
        }
    }
}
