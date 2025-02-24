package com.example.calculadora2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import java.util.Locale

class CronometroActivity : AppCompatActivity() {

    private lateinit var textTime: TextView
    private lateinit var buttonStartStop: Button
    private lateinit var buttonReset: Button
    private lateinit var buttonBack: Button

    private var seconds = 0
    private var running = false
    private var wasRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cronometro)

        textTime = findViewById(R.id.textTime)
        buttonStartStop = findViewById(R.id.buttonStartStop)
        buttonReset = findViewById(R.id.buttonReset)
        buttonBack = findViewById(R.id.buttonBack)

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
        runTimer()

        buttonStartStop.setOnClickListener {
            running = !running
            if (running) {
                buttonStartStop.text = "Pausar"
            } else {
                buttonStartStop.text = "Iniciar"
            }
        }

        buttonReset.setOnClickListener {
            running = false
            seconds = 0
            buttonStartStop.text = "Iniciar"
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) { // Cambio aquí: outState en lugar de savedInstanceState
        super.onSaveInstanceState(outState) // Cambio aquí: outState en lugar de savedInstanceState
        outState.putInt("seconds", seconds) // Cambio aquí: outState en lugar de savedInstanceState
        outState.putBoolean("running", running) // Cambio aquí: outState en lugar de savedInstanceState
        outState.putBoolean("wasRunning", wasRunning) // Cambio aquí: outState en lugar de savedInstanceState
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) {
            running = true
        }
    }

    private fun runTimer() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                val time = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, secs)
                textTime.text = time
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
}