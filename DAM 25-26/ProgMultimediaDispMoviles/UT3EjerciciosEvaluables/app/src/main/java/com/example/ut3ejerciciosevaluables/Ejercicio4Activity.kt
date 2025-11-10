package com.example.ut3ejerciciosevaluables

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.databinding.ActivityEjercicio4Binding

class Ejercicio4Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}