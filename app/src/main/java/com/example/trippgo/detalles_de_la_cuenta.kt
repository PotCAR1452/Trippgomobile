package com.example.trippgo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.trippgo.modelo.usuariomodelo

class detalles_de_la_cuenta : AppCompatActivity() {

    private lateinit var nombreuser: EditText
    private lateinit var contraseña_user: EditText
    private lateinit var comprobar_contraseña: EditText
    private lateinit var btnsiguientepaso: Button
    private var modelouser = usuariomodelo()
    private var enviardatos = Imagen_personal_registrarse()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_de_la_cuenta)

        var nombrecom : String
        var contrasena : String
        var ComprobarContra : String

        nombreuser = findViewById(R.id.txtnombreusuario)
        contraseña_user = findViewById(R.id.txtcontraseña)
        comprobar_contraseña = findViewById(R.id.txtcomprobarcontraseña)
        btnsiguientepaso = findViewById(R.id.btnsiguientepaso)



        //que no solo deje ingresar letras en el campo de nombre de usuario.
        nombreuser.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

        val letterFilter = InputFilter { source, start, end, _, _, _ ->
            val pattern = Regex("[^a-zA-Z]+")
            val input = source?.subSequence(start, end).toString()
            if (pattern.matches(input)) {
                ""
            } else {
                null
            }
        }

        nombreuser.filters = arrayOf(letterFilter)


        //evento al presionar el boton siguiente

        btnsiguientepaso.setOnClickListener {

            nombrecom = nombreuser.text.toString()
            contrasena = contraseña_user.text.toString()
            ComprobarContra = comprobar_contraseña.text.toString()

            if(nombrecom.isEmpty()||ComprobarContra.isEmpty()||contrasena.isEmpty())
            {
                Toast.makeText(this, "No puede dejar vacio el campo", Toast.LENGTH_SHORT).show()
            }

            else {

                if (contrasena == ComprobarContra) {


                    Toast.makeText(this, "$nombrecom", Toast.LENGTH_SHORT).show()

                    Toast.makeText(this, "Se ingresaron los datos correctamente", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, Imagen_personal_registrarse::class.java)
                    intent.putExtra("nombre", nombrecom)
                    intent.putExtra("contrasena", contrasena)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Las contrasenas no coinciden", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}