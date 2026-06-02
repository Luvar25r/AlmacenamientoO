package com.example.almacenamiento

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Actividad 1: Ruta del almacenamiento privado
        val valpath: String = filesDir.absolutePath
        println("Ruta del almacenamiento privado: $valpath")

        // Actividad 2: Crear archivo de texto
        val filename = "datos_usuario.txt"
        val fileContents = "Puntaje: 1500\nNivel: 5"
        openFileOutput(filename, Context.MODE_PRIVATE).use { output ->
            output.write(fileContents.toByteArray())
        }
        println("Archivo '$filename' creado en: $valpath/$filename")
    }
}