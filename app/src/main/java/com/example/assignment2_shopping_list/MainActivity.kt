package com.example.assignment2_shopping_list

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout

import android.support.v7.widget.RecyclerView

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView_Menu : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        }

        recyclerView_Menu = findViewById(R.id.recyclerViewMenu) as RecyclerView
        recyclerView_Menu.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        recyclerView_Menu.adapter = MainAdapter()

        val new_adapter = MainAdapter()
        recyclerView_Menu.adapter = new_adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            var display_fruit : String = ""
            data?.run {
                val fruits : String = data.getStringExtra("fruitName")

                Log.d(MainActivity::class.java.simpleName,fruits)
                display_fruit = fruits
            }
            Toast.makeText(this, "Click ${display_fruit} ", Toast.LENGTH_SHORT).show()
            (recyclerView_Menu.adapter as? MainAdapter)?.additem(display_fruit)
        }
    }
}