package com.example.ut3ejerciciosevaluables

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.databinding.ActivityEjercicio6Binding

class Ejercicio6Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio6Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}