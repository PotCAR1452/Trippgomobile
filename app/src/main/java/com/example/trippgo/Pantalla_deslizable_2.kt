package com.example.trippgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Pantalla_deslizable_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_deslizable2)

        val next = findViewById<Button>(R.id.btnsigiuiente_2_3)

        next.setOnClickListener {
            val intent = Intent(this, Pantalla_deslizable3::class.java)
            startActivity(intent)


        }
    }
}