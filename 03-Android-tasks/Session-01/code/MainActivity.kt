package com.example.train_xml

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.Clock.system

class MainActivity : AppCompatActivity() {
    private lateinit var statusText: TextView
    private var lastTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        statusText = findViewById(R.id.statusText)
        statusText.text = "Activity created on 0 ms"
        lastTime = System.currentTimeMillis()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        statusText.append("\nActivity Started on ${System.currentTimeMillis()-lastTime} ms")
        lastTime = System.currentTimeMillis()
    }

    override fun onResume() {
        super.onResume()
        statusText.append("\nActivity Resumed ${System.currentTimeMillis()-lastTime} ms")
        lastTime = System.currentTimeMillis()
    }
    override fun onPause() {
        super.onPause()
        statusText.append("\nActivity Paused ${System.currentTimeMillis()-lastTime} ms")
        lastTime = System.currentTimeMillis()
    }
    override fun onStop() {
        super.onStop()
        statusText.append("\nActivity stoped ${System.currentTimeMillis()-lastTime} ms")
        lastTime = System.currentTimeMillis()
    }
    override fun onDestroy() {
        super.onDestroy()
        statusText.append("\nActivity Destroyed ${System.currentTimeMillis()-lastTime} ms")
        lastTime = System.currentTimeMillis()
    }
    override fun onRestart() {
        super.onRestart()
        statusText.append("\nActivity Restarted ${System.currentTimeMillis()-lastTime} ms")
        lastTime = System.currentTimeMillis()
    }

}