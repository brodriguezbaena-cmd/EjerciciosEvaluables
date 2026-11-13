package com.example.ejerciciosevaluables

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val tvEstado = findViewById<TextView>(R.id.tvEstado)

        btnIniciar.setOnClickListener {
            btnIniciar.isEnabled = false
            tvEstado.text = "Navegando en 10 segundos..."

            val intent = Intent(this, Ejercicio2DestinoActivity::class.java)

            val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )

            Handler(Looper.getMainLooper()).postDelayed({
                try {
                    pendingIntent.send()
                    finish()
                } catch (e: PendingIntent.CanceledException) {
                    e.printStackTrace()
                }
            }, 10000)
        }
    }
}