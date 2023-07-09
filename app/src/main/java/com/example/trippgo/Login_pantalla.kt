package com.example.trippgo

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.trippgo.modelo.usuariomodelo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class Login_pantalla : AppCompatActivity() {

    //variables de items
    private lateinit var botonlogin: Button
    private lateinit var btnregistrarse: TextView


    //conexiones
    private var connectSql = conexionç()
    private var connectSql2 = DatabaseConnection()
    private var modelouser = usuariomodelo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_pantalla)


        botonlogin = findViewById<Button>(R.id.btnlogin)
        btnregistrarse = findViewById(R.id.registrarse)


        botonlogin.setOnClickListener {

            val intent = Intent(this, Email_register::class.java)
            /*intent.putExtra("iduser", iduser)
            intent.putExtra("nombrecompleto", nombrecomp)
            intent.putExtra("numerotel", numerotel)
            intent.putExtra("nacimiento", nacimi)*/
            startActivity(intent)

        }

        btnregistrarse.setOnClickListener{
            val intent = Intent(this, detalles_de_la_cuenta::class.java)
            startActivity(intent)

        }

        }
    }






/* botonlogin.setOnClickListener {


            try{


                val statement = connectSql.conexiondb()?.createStatement()
                val resulSet = statement?.executeQuery("select Nombre_user, Contraseña from usuarios WHERE id_user=5")


               while (resulSet?.next() == true) {


                    val column1 = resulSet.getString("Nombre_user")
                    val column2 = resulSet.getString("Contraseña")


                    Toast.makeText(this, "$column1, $column2", Toast.LENGTH_LONG).show()
                }

            }catch (ex: SQLException){
                Toast.makeText(this, "5", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "$ex", Toast.LENGTH_SHORT).show()
            }
        }*/



/*
    fun conexionBD(): Connection? {
        var cnn: Connection? = null
        try {
            val politica = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(politica)
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            cnn =
                DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.19/50126;databaseName=trippgo;user=sa;password=123;")
        } catch (e: Exception) {
            Toast.makeText(applicationContext, e.message, Toast.LENGTH_SHORT).show()
        }
        return cnn
    }




    fun obtenerUsuarioPorId(idUsuario: Int): String? {
        var connection: Connection? = null
        var statement: Statement? = null
        var resultSet: ResultSet? = null


        try {
            connection = conexionBD()
            statement = connection?.createStatement()
            resultSet = statement?.executeQuery("SELECT * FROM usuarios WHERE id = $idUsuario")

            if (resultSet?.next() == true) {

                val nombreUsuario = resultSet.getString(2)
                Toast.makeText(this, "$nombreUsuario", Toast.LENGTH_SHORT).show()
                return nombreUsuario
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            resultSet?.close()
            statement?.close()
            connection?.close()
            Toast.makeText(this, "setso", Toast.LENGTH_SHORT).show()
        }

        return null
    }



*/

