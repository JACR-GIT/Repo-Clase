package com.example.ut3ejerciciosevaluables

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.databinding.ActivityEjercicio5Binding

class Ejercicio5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio5Binding
    private var numero = ""
    private var operador = ""
    private var resultadoFinal = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberClickListener = View.OnClickListener {
            val button = it as Button
            numero += button.text.toString()
            actualizar()
        }

        val operatorClickListener = View.OnClickListener {
            val button = it as Button
            if (numero.isNotEmpty()) {
                if (resultadoFinal.isNotEmpty()) {
                    calcular()
                }
                operador = button.text.toString()
                resultadoFinal = numero
                numero = ""
            }
        }

        // Asignar listeners a los botones numéricos
        binding.button0.setOnClickListener(numberClickListener)
        binding.button1.setOnClickListener(numberClickListener)
        binding.button2.setOnClickListener(numberClickListener)
        binding.button3.setOnClickListener(numberClickListener)
        binding.button4.setOnClickListener(numberClickListener)
        binding.button5.setOnClickListener(numberClickListener)
        binding.button6.setOnClickListener(numberClickListener)
        binding.button7.setOnClickListener(numberClickListener)
        binding.button8.setOnClickListener(numberClickListener)
        binding.button9.setOnClickListener(numberClickListener)
        binding.buttonDecimal.setOnClickListener(numberClickListener)

        // Asignar listeners a los operadores
        binding.buttonSuma.setOnClickListener(operatorClickListener)
        binding.buttonRestar.setOnClickListener(operatorClickListener)
        binding.buttonMultiplicar.setOnClickListener(operatorClickListener)
        binding.buttonDividir.setOnClickListener(operatorClickListener)

        // Listener para el botón de igual
        binding.buttonEquals.setOnClickListener {
            if (numero.isNotEmpty() && resultadoFinal.isNotEmpty()) {
                calcular()
                operador = ""
            }
        }

        // Listener para el botón de limpiar
        binding.buttonC.setOnClickListener {
            numero = ""
            operador = ""
            resultadoFinal = ""
            actualizar()
        }
    }

    private fun actualizar() {
        binding.textDisplay.text = if (numero.isNotEmpty()) numero else if (resultadoFinal.isNotEmpty()) resultadoFinal else "0"
    }

    private fun calcular() {
        val num1 = resultadoFinal.toDouble()
        val num2 = numero.toDouble()

        val resultado = when (operador) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
            else -> 0.0
        }

        if (resultado.isNaN()) {
            numero = ""
            resultadoFinal = "Error"
        } else {
            resultadoFinal = resultado.toString()
            numero = resultadoFinal
        }
        actualizar()
        resultadoFinal = ""

    }
}