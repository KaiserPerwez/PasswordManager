package com.kaiser.passwordmanager.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kaiser.passwordmanager.R
import com.kaiser.passwordmanager.model.PasswordModel
import kotlinx.android.synthetic.main.item_password_list_rv.view.*

class PasswordListAdapter(var listPasswordModel: List<PasswordModel>, var applicationContext: Context?) : RecyclerView.Adapter<PasswordListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(applicationContext).inflate(R.layout.item_password_list_rv, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPasswordModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val passwordModel = listPasswordModel.get(position)
        holder.id = passwordModel.id
        holder.txt_title.text = passwordModel.title
        holder.txt_item_username.text = passwordModel.username
        holder.txt_item_password.text = passwordModel.password
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var id: Long = 0
        var txt_title = view.txt_item_title
        var txt_item_username = view.txt_item_username
        var txt_item_password = view.txt_item_password
    }
    fun addItem(passwordModel: PasswordModel){
        var list=listPasswordModel as ArrayList
        list.add(passwordModel)
        listPasswordModel=list

        notifyItemInserted(itemCount-1)
    }
}
