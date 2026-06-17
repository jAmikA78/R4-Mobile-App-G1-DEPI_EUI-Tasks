package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val TAG = "I am here"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate():")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart():")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume():")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart():")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause():")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop():")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy():")

    }

}