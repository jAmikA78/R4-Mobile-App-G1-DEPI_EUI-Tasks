package com.example.lab_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
const val PHONE = "PHONE"
const val MESSAGE = "MESSAGE"
class MainActivity : AppCompatActivity() {
    lateinit var phone : EditText
    lateinit var message : EditText

    lateinit var btn_next : Button
    lateinit var btn_close : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        phone = findViewById(R.id.phone_edit)
        message = findViewById(R.id.message_edit)
        btn_next = findViewById(R.id.btn_next)
        btn_close = findViewById(R.id.btn_close)
        val intent = Intent(this, SecondActivity::class.java)


        btn_next.setOnClickListener {
            intent.putExtra(PHONE,phone.text.toString())
            intent.putExtra(MESSAGE,message.text.toString())
            startActivity(intent)
        }
        btn_close.setOnClickListener {
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