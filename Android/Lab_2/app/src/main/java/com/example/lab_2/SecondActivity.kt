package com.example.lab_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.transition.Visibility

class SecondActivity : AppCompatActivity() {
    lateinit var btn_red : Button
    lateinit var btn_yellow : Button
    lateinit var btn_Green : Button

    lateinit var txt_box_one : TextView
    lateinit var txt_box_two : TextView
    lateinit var txt_box_three : TextView
    lateinit var txt_box_four : TextView
    lateinit var txt_box_five : TextView

    lateinit var layout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        btn_red = findViewById(R.id.btn_red)
        btn_yellow = findViewById(R.id.btn_yellow)
        btn_Green = findViewById(R.id.btn_green)

        txt_box_one = findViewById(R.id.txt_box_one)
        txt_box_two = findViewById(R.id.txt_box_two)
        txt_box_three = findViewById(R.id.txt_box_three)
        txt_box_four = findViewById(R.id.txt_box_four)
        txt_box_five = findViewById(R.id.txt_box_five)


        txt_box_one.visibility = View.INVISIBLE
        txt_box_two.visibility = View.INVISIBLE
        txt_box_three.visibility = View.INVISIBLE
        txt_box_four.visibility = View.INVISIBLE
        txt_box_five.visibility = View.INVISIBLE

        layout = findViewById(R.id.main)

        layout.setOnClickListener {
            if(!txt_box_one.isVisible){
                txt_box_one.visibility = View.VISIBLE

            }
            else if(!txt_box_two.isVisible){
                txt_box_two.visibility = View.VISIBLE
            }
        }

        btn_red.setOnClickListener {
            if (!txt_box_three.isVisible)
                txt_box_three.visibility = View.VISIBLE

        }
        btn_yellow.setOnClickListener {
            if (!txt_box_four.isVisible)
                txt_box_four.visibility = View.VISIBLE

        }
        btn_Green.setOnClickListener {
            if (!txt_box_five.isVisible)
                txt_box_five.visibility = View.VISIBLE

        }

    }
}