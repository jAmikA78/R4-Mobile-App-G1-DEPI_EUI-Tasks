package com.example.train_xml

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class InfoActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val phone = intent.getStringExtra("phone")
        val message = intent.getStringExtra("message")


        val phoneText = findViewById<TextView>(R.id.infoPhone)
        val messageText = findViewById<TextView>(R.id.infoMessage)
        val closeButton = findViewById<TextView>(R.id.buttonClose)
        closeButton.setOnClickListener {
            finish()
        }

        phoneText.text = phone
        messageText.text = message
    }
}
