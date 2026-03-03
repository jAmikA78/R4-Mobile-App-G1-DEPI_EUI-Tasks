package com.example.train_xml

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.Clock.system

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val backgroundView = findViewById<View>(R.id.main)

        backgroundView.setOnClickListener {
            backgroundView.setBackgroundColor(ContextCompat.getColor(this, R.color.light_grey))
        }

        val boxOne = findViewById<TextView>(R.id.box_one)
        var color = ContextCompat.getColor(this, R.color.dark_grey)
        boxOne.setOnClickListener {
            boxOne.setBackgroundColor(color)
        }
        val boxTwo = findViewById<TextView>(R.id.box_two)
        boxTwo.setOnClickListener {
            color = ContextCompat.getColor(this, R.color.grey)
            boxTwo.setBackgroundColor(color)
        }
        val boxThree = findViewById<TextView>(R.id.box_three)
        boxThree.setOnClickListener {
            color = ContextCompat.getColor(this, R.color.red)
            boxThree.setBackgroundColor(color)
        }
        val boxFour = findViewById<TextView>(R.id.box_four)
        boxFour.setOnClickListener {
            color = ContextCompat.getColor(this, R.color.yellow)
            boxFour.setBackgroundColor(color)
        }
        val boxFive = findViewById<TextView>(R.id.box_five)
        boxFive.setOnClickListener {
            color = ContextCompat.getColor(this, R.color.green)
            boxFive.setBackgroundColor(color)
        }



        
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}