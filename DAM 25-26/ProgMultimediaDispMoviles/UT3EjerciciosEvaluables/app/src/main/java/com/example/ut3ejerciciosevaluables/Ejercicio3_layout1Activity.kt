package com.example.ut3ejerciciosevaluables

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.Ejercicio3_layout1Activity
import com.example.ut3ejerciciosevaluables.Ejercicio3_layout2Activity
import com.example.ut3ejerciciosevaluables.Ejercicio3_layout3Activity
import com.example.ut3ejerciciosevaluables.MainActivity

class Ejercicio3_layout1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ejercicio3_layout1)

        val boton1 = findViewById<Button>(R.id.btn1)
        val boton2 = findViewById<Button>(R.id.btn2)
        val boton3 = findViewById<Button>(R.id.btn3)
        val boton4 = findViewById<Button>(R.id.btn4)


        // Botón 1: Barras Rojas y Azules
        boton1.setOnClickListener {
            val intent = Intent(this, Ejercicio3Activity::class.java)
            startActivity(intent)
        }

        // Botón 2: Ajedrez Rojo
        boton2.setOnClickListener {
            val intent = Intent(this, Ejercicio3_layout3Activity::class.java)
            startActivity(intent)
        }

        // Botón 3: Barras Verdes
        boton3.setOnClickListener {
            val intent = Intent(this, Ejercicio3_layout2Activity::class.java)
            startActivity(intent)
        }

        // Botón 4: Navega a MainActivity (pantalla principal)
        boton4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
