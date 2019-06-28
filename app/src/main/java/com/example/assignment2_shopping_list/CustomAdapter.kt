package com.example.assignment2_shopping_list

import android.app.Activity
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*

class CustomAdapter (val userList: ArrayList<User>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


    var linstener : View.OnClickListener? = null

    fun setListener(l: View.OnClickListener) {
        this.linstener = l
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.layout_list,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val user : User = userList[p1]

        p0?.textViewName.text = user.name
        p0?.textViewAddress.text = user.address

        p0.textViewName.setOnClickListener(linstener)
    }


    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val textViewName = itemView.findViewById<TextView >(R.id.textViewName)
        val textViewAddress = itemView.findViewById(R.id.textViewAddress) as TextView
    }
}