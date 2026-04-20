package com.example.lab_1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val LIFECYCLE = "LIFECYCLE: "
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d(LIFECYCLE,"onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE,"onStart()")

    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE,"onResume()")

    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE,"onPause()")

    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE,"onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE,"onDestroy()")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LIFECYCLE,"onRestart()")

    }
}