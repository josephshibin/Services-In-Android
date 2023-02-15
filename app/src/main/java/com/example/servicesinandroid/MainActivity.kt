package com.example.servicesinandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.servicesinandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)


        mainBinding.button.setOnClickListener {
            val intent = Intent(this, ClassicServices::class.java)
            startService(intent)

        }
        mainBinding.button2.setOnClickListener {

        }
        mainBinding.button3.setOnClickListener {
            val intent = Intent(this, ClassicServices::class.java)
            stopService(intent)

        }
    }

}
// classicService class works on main thread
// JobIntentService class works on its-own thread