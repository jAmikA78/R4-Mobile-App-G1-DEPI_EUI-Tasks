package com.example.lab_3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    lateinit var phone : TextView
    lateinit var message : TextView

    lateinit var btn_close2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        phone = findViewById(R.id.phone)
        message = findViewById(R.id.message)
        phone.text = intent.getStringExtra(PHONE)
        message.text = intent.getStringExtra(MESSAGE)

        btn_close2 = findViewById(R.id.btn_close2)
        btn_close2.setOnClickListener {
            finish()
        }

    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle: ","onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle: ","onDestroy()")

    }
}