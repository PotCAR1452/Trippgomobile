package com.example.trippgo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.trippgo.modelo.usuariomodelo
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class Imagen_personal_registrarse : AppCompatActivity() {


    private var modelouser = usuariomodelo()
    private lateinit var btningresaruser: Button
    private lateinit var btningresarimgage: ImageView
    private lateinit var perfiliamgen: ImageView
    public lateinit var imageenviar : Bitmap
    private val PICK_IMAGE_REQUEST = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen_personal_registrarse)




        btningresaruser = findViewById(R.id.btningresaruser)
        btningresarimgage = findViewById(R.id.agregarimg)
        perfiliamgen = findViewById(R.id.imgf)



        btningresarimgage.setOnClickListener {
            selectImage()
        }


        btningresaruser.setOnClickListener {

            
            val nombre = intent.getStringExtra("nombre").toString()
            val contraseña = intent.getStringExtra("contrasena").toString()

            //Toast.makeText(this, "$nombre", Toast.LENGTH_SHORT).show()

            // Obtener la imagen asociada al ImageView
            val imagenDrawable: Drawable? = perfiliamgen.drawable

            if (imagenDrawable != null && imagenDrawable is BitmapDrawable) {
                // Obtener el objeto Bitmap desde el Drawable
                val imagenBitmap: Bitmap = imagenDrawable.bitmap

                // Convertir el objeto Bitmap a un archivo en el almacenamiento
                val imagenFile: File = File(cacheDir, "imagen.jpg")

                try {
                    // Guardar el Bitmap en el archivo
                    val outputStream: OutputStream = FileOutputStream(imagenFile)
                    imagenBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                    outputStream.flush()
                    outputStream.close()

                    // Obtener la ruta del archivo de imagen
                    val imagenPath: String = imagenFile.absolutePath

                    Toast.makeText(this, "$imagenBitmap,$nombre,$contraseña", Toast.LENGTH_SHORT).show()
                    // Setear el objeto Bitmap en el modelo (modelouser)
                    modelouser.setimguser(imagenBitmap, nombre, contraseña)

                    // Llamar a la función getNombre() en el modelo (modelouser)
                    if (modelouser.getNombre()) {

                        Toast.makeText(this, "Se envió la imagen a la base de datos", Toast.LENGTH_SHORT).show()

                        //pasar valor de id user

                        val iduser = modelouser.getiduser();
                        Toast.makeText(this, "$iduser", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, datos_personales_registrarse::class.java)
                        intent.putExtra("iduser", iduser)
                        startActivity(intent)



                    } else {
                        Toast.makeText(this, "No se ha enviado nada", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error al guardar la imagen", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "No se ha seleccionado una imagen", Toast.LENGTH_SHORT).show()
            }
        }


        //funcion de aclopar la imagen a el imageView
    }

    private fun selectImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }


   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri = data.data
            perfiliamgen.setImageURI(imageUri)
        }

    }
}

