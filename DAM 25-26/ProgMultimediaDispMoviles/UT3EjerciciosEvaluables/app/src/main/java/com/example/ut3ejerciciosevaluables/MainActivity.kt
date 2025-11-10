package com.example.ut3ejerciciosevaluables

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ut3ejerciciosevaluables.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnEjercicio1.setOnClickListener {
            startActivity(Intent(this, Ejercicio1::class.java))
        }

        binding.btnEjercicio2.setOnClickListener {
            startActivity(Intent(this, Ejercicio2::class.java))
        }

        binding.btnEjercicio3.setOnClickListener {
            startActivity(Intent(this, Ejercicio3::class.java))
        }

        binding.btnEjercicio4.setOnClickListener {
            startActivity(Intent(this, Ejercicio4::class.java))
        }

        binding.btnEjercicio5.setOnClickListener {
            startActivity(Intent(this, Ejercicio5::class.java))
        }

        binding.btnEjercicio6.setOnClickListener {
            startActivity(Intent(this, Ejercicio6::class.java))
        }
    }
}