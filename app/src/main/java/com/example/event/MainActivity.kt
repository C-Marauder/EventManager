package com.example.event

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.xqy.androidx.event.registerEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener {
            startActivity(Intent(this,BActivity::class.java))
        }
        registerEvent<String>("a"){
            Log.e("==","=====")
            textView.text = it
            textView.textSize = 24f
        }
    }
}
