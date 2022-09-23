package com.example.logindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    private lateinit var imageView2 : ImageView
    private lateinit var imageView3 : ImageView
    private lateinit var imageView7 : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        imageView2 = findViewById(R.id.imageView2)
        imageView3 = findViewById(R.id.imageView3)
        imageView7 = findViewById(R.id.imageView7)

        imageView2.setOnClickListener{
            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
            }
        imageView3.setOnClickListener{
            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
        imageView7.setOnClickListener{
            intent = Intent(applicationContext, seminarKP::class.java)
            startActivity(intent)
        }
        }
    }
