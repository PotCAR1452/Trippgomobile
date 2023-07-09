package com.example.trippgo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.IOException

class mail_registraarse : AppCompatActivity() {

    lateinit var btnsiguiente : Button
    lateinit var txtcorreo : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail_registraarse)

        txtcorreo = findViewById(R.id.btnsiguientepaso2)
        btnsiguiente = findViewById(R.id.txtcorreoelectronico)


        btnsiguiente.setOnClickListener {

            val iduser = intent.getStringExtra("iduser").toString()
            val nombrecomp = intent.getStringExtra("nombrecompleto").toString()
            val numerotel = intent.getStringExtra("numerotel").toString()
            val nacimiento = intent.getStringExtra("nacimiento").toString()

            val correoelectronico = txtcorreo.text.toString()



        }

    }
}