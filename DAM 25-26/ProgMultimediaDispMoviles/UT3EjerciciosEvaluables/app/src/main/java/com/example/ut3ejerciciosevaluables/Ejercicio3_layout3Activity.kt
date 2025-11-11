package com.example.ut3ejerciciosevaluables

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// Asegúrate de tener los imports de todas las Activities a las que quieres navegar.
import com.example.ut3ejerciciosevaluables.Ejercicio3_layout1Activity
import com.example.ut3ejerciciosevaluables.Ejercicio3_layout2Activity
import com.example.ut3ejerciciosevaluables.MainActivity

class Ejercicio3_layout3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Carga el layout XML que contiene los cuatro botones.
        setContentView(R.layout.activity_ejercicio3_layout3)

        // 2. Busca cada botón en el layout usando su ID.
        val boton1 = findViewById<Button>(R.id.btn1)
        val boton2 = findViewById<Button>(R.id.btn2)
        val boton3 = findViewById<Button>(R.id.btn3)
        val boton4 = findViewById<Button>(R.id.btn4)

        // 3. Asigna a cada botón la acción de navegar a su página correspondiente.

        // Botón 1 -> Barras Azules
        boton1.setOnClickListener {
            val intent = Intent(this, Ejercicio3_layout1Activity::class.java)
            startActivity(intent)
        }

        // Botón 2 -> Barras Verdes
        boton2.setOnClickListener {
            val intent = Intent(this, Ejercicio3_layout2Activity::class.java)
            startActivity(intent)
        }

        // Botón 3 -> Barras Rojas y Azules
        boton3.setOnClickListener {
            val intent = Intent(this, Ejercicio3Activity::class.java)
            startActivity(intent)
        }

        // Botón 4 -> Navega a MainActivity
        boton4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
