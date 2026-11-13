package com.example.ejerciciosevaluables

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2DestinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this).apply {
            text = "segunda pantalla tras 10 segundos"
            textSize = 20f
            gravity = Gravity.CENTER
        }
        setContentView(tv)
    }
}