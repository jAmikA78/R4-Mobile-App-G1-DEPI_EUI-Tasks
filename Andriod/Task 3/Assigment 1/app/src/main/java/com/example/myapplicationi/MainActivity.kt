package com.example.myapplicationi

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.format.TextStyle

class MainActivity : AppCompatActivity() {
    lateinit var txt1: TextView
    lateinit var txt2: TextView
    lateinit var txt3: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //text inflation
        txt1=findViewById(R.id.textView6)//RED
        txt2=findViewById(R.id.textView7)//Yellow
        txt3=findViewById(R.id.textView8)//Green

        //button inflation
        val button0: Button=findViewById(R.id.button4)
        button0.setOnClickListener { view ->
            txt1.setBackgroundColor(Color.RED)
        }

        val button1: Button=findViewById(R.id.button5)
        button1.setOnClickListener { view ->
            txt2.setBackgroundColor(Color.YELLOW)
        }
        val button2: Button=findViewById(R.id.button6)
        button2.setOnClickListener { view ->
            txt3.setBackgroundColor(Color.GREEN)
        }


        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}