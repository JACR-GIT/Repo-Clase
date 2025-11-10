package com.example.ut3ejerciciosevaluables

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.databinding.ActivityEjercicio5Binding

class Ejercicio5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio5Binding
    private var currentNumber = ""
    private var currentOperator = ""
    private var result = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberClickListener = View.OnClickListener {
            val button = it as Button
            currentNumber += button.text.toString()
            updateDisplay()
        }

        val operatorClickListener = View.OnClickListener {
            val button = it as Button
            if (currentNumber.isNotEmpty()) {
                if (result.isNotEmpty()) {
                    calculate()
                }
                currentOperator = button.text.toString()
                result = currentNumber
                currentNumber = ""
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
        binding.buttonAdd.setOnClickListener(operatorClickListener)
        binding.buttonSubtract.setOnClickListener(operatorClickListener)
        binding.buttonMultiply.setOnClickListener(operatorClickListener)
        binding.buttonDivide.setOnClickListener(operatorClickListener)

        // Listener para el botón de igual
        binding.buttonEquals.setOnClickListener {
            if (currentNumber.isNotEmpty() && result.isNotEmpty()) {
                calculate()
                currentOperator = ""
            }
        }

        // Listener para el botón de limpiar
        binding.buttonClear.setOnClickListener {
            currentNumber = ""
            currentOperator = ""
            result = ""
            updateDisplay()
        }
    }

    private fun updateDisplay() {
        binding.textDisplay.text = if (currentNumber.isNotEmpty()) currentNumber else if (result.isNotEmpty()) result else "0"
    }

    private fun calculate() {
        val num1 = result.toDouble()
        val num2 = currentNumber.toDouble()

        val calculatedResult = when (currentOperator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN // Manejar división por cero
            else -> 0.0
        }

        if (calculatedResult.isNaN()) {
            currentNumber = ""
            result = "Error"
        } else {
            result = calculatedResult.toString()
            currentNumber = result
        }
        updateDisplay()
        result = ""

    }
}