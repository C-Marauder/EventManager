package com.example.event

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xqy.androidx.event.sendEvent
import kotlinx.android.synthetic.main.b_activity.*

class BActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_activity)
        textView.setOnClickListener {
            sendEvent("a","Hello MainActivity")
        }

    }

}