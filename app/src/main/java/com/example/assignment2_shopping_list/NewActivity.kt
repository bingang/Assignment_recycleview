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

class NewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)

        val users = ArrayList<User>()

        users.add(User("Apple","$10"))
        users.add(User("Banana","$20"))
        users.add(User("Orange","$30"))
        users.add(User("Cherry","$40"))
        users.add(User("Blackberries","$50"))
        users.add(User("Breadfruit","$60"))
        users.add(User("Carambola","$70"))
        users.add(User("Cranberries","$480"))
        users.add(User("Elderberries","$290"))
        users.add(User("Currant","$760"))
        users.add(User("Mulberry","$340"))
        users.add(User("Mango","$190"))
        users.add(User("Akee","$900"))



        val adapter = CustomAdapter(users).apply {
            setListener(View.OnClickListener {
                Log.d("click","textViewName click")
                val intent = Intent()
                intent.putExtra("textViewName", (it as TextView).text)

                setResult(Activity.RESULT_OK, intent)
                finish()
            })
        }
        recyclerView.adapter = adapter




    }

}