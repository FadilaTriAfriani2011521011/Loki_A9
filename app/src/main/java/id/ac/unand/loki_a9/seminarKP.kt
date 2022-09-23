package com.example.logindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class seminarKP : AppCompatActivity() {
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar_kp)
        supportActionBar?.hide()

        button = findViewById(R.id.button)

        button.setOnClickListener{
            intent = Intent(applicationContext, absenKP::class.java)
            startActivity(intent)
        }

    }
}