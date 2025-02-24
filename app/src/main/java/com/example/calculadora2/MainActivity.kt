package com.example.calculadora2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculator = findViewById<Button>(R.id.buttonCalculator)
        val buttonCronometro = findViewById<Button>(R.id.buttonCronometro)

        buttonCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        buttonCronometro.setOnClickListener {
            val intent = Intent(this, CronometroActivity::class.java)
            startActivity(intent)
        }
    }
}