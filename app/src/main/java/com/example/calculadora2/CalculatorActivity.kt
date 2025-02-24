package com.example.calculadora2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
//import androidx.compose.ui.semantics.text

class CalculatorActivity : AppCompatActivity() {

    private lateinit var calculate: TextView
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonAdd: Button
    private lateinit var buttonSub: Button
    private lateinit var buttonMult: Button
    private lateinit var buttonDiv: Button
    private lateinit var buttonDec: Button
    private lateinit var buttonEqual: Button
    private lateinit var buttonAC: Button
    private lateinit var buttonBack: Button

    private var first: Float = 0f
    private var second: Float = 0f
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        // Inicializar las vistas
        calculate = findViewById(R.id.calculate)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSub = findViewById(R.id.buttonSub)
        buttonMult = findViewById(R.id.buttonMult)
        buttonDiv = findViewById(R.id.buttonDiv)
        buttonDec = findViewById(R.id.buttonDec)
        buttonEqual = findViewById(R.id.buttonEqual)
        buttonAC = findViewById(R.id.buttonAC)
        buttonBack = findViewById(R.id.buttonBack)

        // Configurar los listeners para los botones numéricos
        val numberButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
        for (button in numberButtons) {
            button.setOnClickListener {
                val currentText = calculate.text.toString()
                val newText = if (currentText == "0") button.text.toString() else currentText + button.text.toString()
                calculate.text = newText
            }
        }

// Configurar los listeners para los botones de operación
        buttonAdd.setOnClickListener { setOperator("+") }
        buttonSub.setOnClickListener { setOperator("-") }
        buttonMult.setOnClickListener { setOperator("*") }
        buttonDiv.setOnClickListener { setOperator("/") }

        // Configurar el listener para el botón de igual
        buttonEqual.setOnClickListener { calculateResult() }

        // Configurar el listener para el botón AC
        buttonAC.setOnClickListener { clearCalculator() }

        // Configurar el listener para el botón decimal
        buttonDec.setOnClickListener { addDecimal() }

        // Configurar el listener para el botón de regresar al menú
        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setOperator(op: String) {
        first = calculate.text.toString().toFloat()
        operator = op
        calculate.text = "0"
    }

    private fun calculateResult() {
        second = calculate.text.toString().toFloat()
        val result = when (operator) {
            "+" -> first + second
            "-" -> first - second
            "*" -> first * second
            "/" -> if (second != 0f) first / second else 0f // Manejar división por cero
            else -> 0f
        }
        calculate.text = result.toString()
    }

    private fun clearCalculator() {
        first = 0f
        second = 0f
        operator = ""
        calculate.text = "0"
    }

    private fun addDecimal() {
        val currentText = calculate.text.toString()
        if (!currentText.contains(".")) {
            calculate.text = currentText + "."
        }
    }
}