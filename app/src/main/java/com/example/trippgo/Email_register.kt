package com.example.trippgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.trippgo.R
import com.example.trippgo.modelo.usuariomodelo
import java.sql.Date
import java.text.SimpleDateFormat

class Email_register : AppCompatActivity() {

    lateinit var btnsiguiente : Button
    lateinit var txtcorreo : EditText
    private var modelouser = usuariomodelo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_register)


        btnsiguiente = findViewById(R.id.btnsiguientepas)
        txtcorreo = findViewById(R.id.txtcorreoelectronic)


        btnsiguiente.setOnClickListener {

            val iduser = intent.getStringExtra("iduser").toString()
            val iduser2 : Int = iduser.toInt()
            val nombrecomp = intent.getStringExtra("nombrecompleto").toString()
            val numerotel = intent.getStringExtra("numerotel").toString()
            val numerotel2 : Int = numerotel.toInt()
            val nacimiento = intent.getStringExtra("nacimiento").toString()

            val correoelectronico = txtcorreo.text.toString()

            Toast.makeText(this, "$iduser2,$nombrecomp,$numerotel,$nacimiento,$correoelectronico", Toast.LENGTH_SHORT).show()


           modelouser.setdatospersonales(iduser2,nombrecomp, numerotel2,
                nacimiento,correoelectronico)

           if (modelouser.getagregarpersona() == "true"){

                Toast.makeText(this, "se han ingresado los datos correctamente", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, codigo_de_verificacion_registrarse::class.java)
                startActivity(intent)

            }
            else {
                val error : String = modelouser.getagregarpersona()
                Toast.makeText(this, "$error", Toast.LENGTH_SHORT).show()
            }



        }
    }
}