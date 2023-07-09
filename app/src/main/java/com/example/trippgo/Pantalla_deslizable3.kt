package com.example.trippgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Pantalla_deslizable3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_deslizable3)


        val next = findViewById<Button>(R.id.btn_deslizabletologin)

        next.setOnClickListener {
            val intent = Intent(this, Login_pantalla::class.java)
            startActivity(intent)


        }

    }
}