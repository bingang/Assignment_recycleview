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

class SecondAdapter (val fruitList: ArrayList<Fruit>) : RecyclerView.Adapter<SecondAdapter.ViewHolder>(){


    var linstener : View.OnClickListener? = null

    fun setListener(l: View.OnClickListener) {
        this.linstener = l
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.layout_list,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val user : Fruit = fruitList[p1]

        p0?.fruitName.text = user.name
        p0?.fruitPrice.text = user.price

        p0.fruitName.setOnClickListener(linstener)
    }


    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val fruitName = itemView.findViewById<TextView >(R.id.fruitName)
        val fruitPrice = itemView.findViewById(R.id.fruitPrice) as TextView
    }
}