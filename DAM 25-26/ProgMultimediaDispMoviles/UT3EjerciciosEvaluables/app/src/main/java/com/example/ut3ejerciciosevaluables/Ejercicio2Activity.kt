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

            // 1. Creamos el Intent normal que queremos ejecutar en el futuro.
            val intent = Intent(this, Ejercicio2DestinoActivity::class.java)

            // 2. Envolvemos nuestro Intent en un PendingIntent.
            // Le damos permiso al sistema para que ejecute este Intent más tarde.
            val pendingIntent = PendingIntent.getActivity(
                this,
                0, // requestCode, no es importante para este ejemplo
                intent,
                PendingIntent.FLAG_IMMUTABLE // Flag de seguridad
            )

            // 3. Usamos un Handler para programar la ejecución del PendingIntent.
            Handler(Looper.getMainLooper()).postDelayed({
                try {
                    // 4. Pasados los 10 segundos, se ejecuta este código y se "envía" el PendingIntent.
                    pendingIntent.send()
                } catch (e: PendingIntent.CanceledException) {
                    // Manejar el caso de que el PendingIntent fuese cancelado.
                    e.printStackTrace()
                }
            }, 10000) // 10000 milisegundos = 10 segundos
        }
    }
}