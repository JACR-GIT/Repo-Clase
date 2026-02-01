package com.example.ut3ejerciciosevaluables

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.databinding.ActivityEjercicio2DestinoBinding

class Ejercicio2DestinoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio2DestinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio2DestinoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}