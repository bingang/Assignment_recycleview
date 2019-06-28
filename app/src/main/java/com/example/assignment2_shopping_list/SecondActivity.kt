package com.example.assignment2_shopping_list

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_list.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        val fruits = ArrayList<Fruit>()

        fruits.add(Fruit("Apple","$10"))
        fruits.add(Fruit("Banana","$20"))
        fruits.add(Fruit("Orange","$30"))
        fruits.add(Fruit("Cherry","$40"))
        fruits.add(Fruit("Blackberries","$50"))
        fruits.add(Fruit("Breadfruit","$60"))
        fruits.add(Fruit("Carambola","$70"))
        fruits.add(Fruit("Cranberries","$480"))
        fruits.add(Fruit("Elderberries","$290"))
        fruits.add(Fruit("Currant","$760"))
        fruits.add(Fruit("Mulberry","$340"))
        fruits.add(Fruit("Mango","$190"))
        fruits.add(Fruit("Akee","$900"))



        val adapter = SecondAdapter(fruits).apply {
            setListener(View.OnClickListener {
                Log.d("click","fruitName click")
                val intent = Intent()
                intent.putExtra("fruitName", (it as TextView).text)

                setResult(Activity.RESULT_OK, intent)
                finish()
            })
        }
        recyclerView.adapter = adapter




    }

}