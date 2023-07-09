package com.example.trippgo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val next = findViewById<Button>(R.id.btnSiguiente_1pan_to_2_pant)

        next.setOnClickListener {
            val intent = Intent(this@MainActivity, Pantalla_deslizable_2::class.java)
            startActivity(intent)


        }
    }
}