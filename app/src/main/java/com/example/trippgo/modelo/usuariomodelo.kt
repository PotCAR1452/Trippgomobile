package com.example.trippgo.modelo

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.example.trippgo.DatabaseConnection
import com.example.trippgo.Imagen_personal_registrarse
import com.example.trippgo.conexionç
import java.io.ByteArrayOutputStream
import java.sql.Date
import java.sql.PreparedStatement
import java.sql.SQLException
import java.text.SimpleDateFormat

class usuariomodelo {

    private var connectSql = conexionç()

    //variables datos usuario----------------------

    var nombre: String = ""
    var contraseña: String = ""
    lateinit var imagen: Bitmap

    //variables datos personales----------------------

    var Iduser : Int = 0
    var nombrecompleto : String = ""
    var numerotel : Int = 0
    var nacimiento: String = ""
    var correo: String = ""


    //incio de las fucniones set----------------
    fun setimguser(imagen: Bitmap, nombre: String, contraseña: String) {
        this.imagen = imagen
        this.nombre = nombre
        this.contraseña = contraseña

    }



    fun setdatospersonales(iduser : Int, NombreCompleto : String, NumeroTel : Int, Nacimiento :  String, correoEle : String){

        this.Iduser = iduser
        this.nombrecompleto = NombreCompleto
        this.numerotel = NumeroTel
        this.nacimiento = Nacimiento
        this.correo = correoEle

    }


    //incio de las fucniones get----------------


    fun getagregarpersona(): String {
        try {
            val agregarpersonas: PreparedStatement = connectSql.conexiondb()?.prepareStatement("INSERT INTO personas (Nombrecompleto, fechanacimiento, numerotelefono, Correo_Electronico, id_user) VALUES (?, ?, ?, ?, ?)")!!

            agregarpersonas.setString(1, nombrecompleto)
            agregarpersonas.setString(2, nacimiento)
            agregarpersonas.setString(3, numerotel.toString())
            agregarpersonas.setString(4, correo)
            agregarpersonas.setString(5, Iduser.toString())

            agregarpersonas.executeUpdate()

            return "true"
        } catch (ex: SQLException) {
            println(ex)
            return "$ex"
        }
    }

        fun getiduser(): String {

            try {
                val statement: PreparedStatement? = connectSql.conexiondb()?.prepareStatement("SELECT id_user FROM usuarios WHERE (Nombre_user = ? AND Contraseña = ?)")

                statement?.setString(1, nombre) // Reemplaza el primer signo de interrogación con el valor de "nombre"
                statement?.setString(2, contraseña) // Reemplaza el segundo signo de interrogación con el valor de "contraseña"

                val resultSet = statement?.executeQuery()

                while (resultSet?.next() == true) {
                    val column1: String = resultSet.getString("id_user")
                    return column1
                }
            } catch (ex: SQLException) {
                println(ex)
            }

            return "nada"

        }


    fun getNombre(): Boolean {

        try {

            val agregarusuarios: PreparedStatement = connectSql.conexiondb()?.prepareStatement("insert into usuarios (Nombre_user, Contraseña, imagen) values (?, ?, ?)")!!

                agregarusuarios.setString(1, nombre)
                agregarusuarios.setString(2, contraseña)
                val stream = ByteArrayOutputStream()
                imagen.compress(Bitmap.CompressFormat.PNG, 100, stream)
                val imagenBytes = stream.toByteArray()
                agregarusuarios.setBytes(3, imagenBytes)

                agregarusuarios.executeUpdate()



            return true


        } catch (ex: SQLException) {
            println(ex)
            return false
        }





    }

}

/**/