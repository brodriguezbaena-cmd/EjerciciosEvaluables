package com.example.ejerciciosevaluables

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Ejercicio3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        findViewById<Button>(R.id.btnLayout1).setOnClickListener { abrirEstructura(1) }
        findViewById<Button>(R.id.btnLayout2).setOnClickListener { abrirEstructura(2) }
        findViewById<Button>(R.id.btnLayout3).setOnClickListener { abrirEstructura(3) }
    }

    private fun abrirEstructura(tipo: Int) {
        val intent = Intent(this, Ejercicio3TargetActivity::class.java)
        intent.putExtra("TIPO_LAYOUT", tipo)
        startActivity(intent)
    }
}