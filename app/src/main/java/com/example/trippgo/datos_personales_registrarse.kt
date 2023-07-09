package com.example.trippgo

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.trippgo.modelo.usuariomodelo
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Calendar

class datos_personales_registrarse : AppCompatActivity() {


    private lateinit var btnpasosigu: Button
    private lateinit var fechanacimiento : EditText
    private var modelouser = usuariomodelo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_personales_registrarse)

        btnpasosigu = findViewById(R.id.btnsiguientepaso1)
        val nombreComple = findViewById<EditText>(R.id.txtnombrecompleto)
        val numeroTel = findViewById<EditText>(R.id.txtnumerotelefono)
        fechanacimiento = findViewById<EditText>(R.id.txtfechanacimiento)
        val btncalendario = findViewById<ImageView>(R.id.calendario)



        btncalendario.setOnClickListener {
            mostrarCalendario()
        }



        btnpasosigu.setOnClickListener {

            val iduser = intent.getStringExtra("iduser").toString()
            val nombrecomp : String =  nombreComple.text.toString();
            val numerotel : String = numeroTel.text.toString();
            val nacimi : String = fechanacimiento.text.toString()
            Toast.makeText(this, "$iduser", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Email_register::class.java)
            intent.putExtra("iduser", iduser)
            intent.putExtra("nombrecompleto", nombrecomp)
            intent.putExtra("numerotel", numerotel)
            intent.putExtra("nacimiento", nacimi)
            startActivity(intent)

        }


    }

    private fun mostrarCalendario() {
        // Obtener la fecha actual para establecerla como fecha predeterminada en el calendario
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Crear el DatePickerDialog con la fecha actual como fecha predeterminada
        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            // Actualizar el EditText con la fecha seleccionada por el usuario
            fechanacimiento.setText("$dayOfMonth/${monthOfYear + 1}/$year")
        }, year, month, day)

        // Mostrar el DatePickerDialog
        datePickerDialog.show()
    }
}