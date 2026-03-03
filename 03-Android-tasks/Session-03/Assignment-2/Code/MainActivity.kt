package com.example.train_xml

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val phoneField = findViewById<TextView>(R.id.phoneField)
        val messageField = findViewById<TextView>(R.id.messageField)
        val buttonClose = findViewById<TextView>(R.id.buttonReset)
        buttonClose.setOnClickListener {
            phoneField.text = ""
            messageField.text = ""
        }
        val buttonNext = findViewById<TextView>(R.id.buttonNext)
        buttonNext.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("phone", phoneField.text.toString())
            intent.putExtra("message", messageField.text.toString())
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}