package com.example.assignment2_shopping_list

import android.app.Activity
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.layout_buy.*
import kotlinx.android.synthetic.main.layout_buy.*

class MainAdapter() : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    var fruitList = ArrayList<FruitBuy>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.layout_buy,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val user : FruitBuy = fruitList[p1]
        p0.buy_name.text = user.thing

    }

    public fun additem(item: String) {
        fruitList.add(FruitBuy(item))
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val buy_name = itemView.findViewById(R.id.buy_name) as TextView
    }
}