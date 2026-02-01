package com.example.ut3ejerciciosevaluables

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.databinding.ActivityEjercicio2Binding
import kotlin.jvm.java

class Ejercicio2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavegarRetrasado.setOnClickListener {
            Toast.makeText(this, "Navegando a la siguiente pantalla en 10 segundos...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Ejercicio2DestinoActivity::class.java)

            val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )

            Handler(Looper.getMainLooper()).postDelayed({
                try {
                    pendingIntent.send()
                } catch (e: PendingIntent.CanceledException) {
                    e.printStackTrace()
                }
            }, 10000)
        }
    }
}