package com.example.ut3ejerciciosevaluables// Revisa que este sea tu paquete

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.databinding.ActivityEjercicio4Binding

class Ejercicio4Activity : AppCompatActivity() {

    // La variable 'binding' nos dará acceso a las vistas del layout si las necesitáramos.
    // En este caso, no necesitamos interactuar con ninguna vista, pero es una buena práctica usarlo.
    private lateinit var binding: ActivityEjercicio4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. "Inflar" el layout: Android lee el archivo activity_ejercicio4.xml y crea los objetos de vista en memoria.
        binding = ActivityEjercicio4Binding.inflate(layoutInflater)

        // 2. Establecer la vista de contenido: Le decimos a la actividad que esta es la interfaz que debe mostrar en pantalla.
        setContentView(binding.root)
    }
}