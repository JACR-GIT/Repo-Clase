package com.example.ut3ejerciciosevaluables

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.databinding.ActivityEjercicio3Binding

class Ejercicio3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLayout1.setOnClickListener {
            startActivity(Intent(this, Layout1Activity::class.java))
        }
        /*
        binding.btnLayout2.setOnClickListener {
            startActivity(Intent(this, Layout2Activity::class.java))
        }
        binding.btnLayout3.setOnClickListener {
            startActivity(Intent(this, Layout3Activity::class.java))
        }
        */
    }
}