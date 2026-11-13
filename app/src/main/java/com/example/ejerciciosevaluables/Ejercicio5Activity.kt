package com.example.ejerciciosevaluables

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio5Activity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var primerNumero = 0.0
    private var operacion = ""
    private var nuevoNumero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        tvDisplay = findViewById(R.id.tvDisplay)

        val botonesNum = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnPunto
        )

        for (id in botonesNum) {
            findViewById<Button>(id).setOnClickListener { v ->
                val textoBoton = (v as Button).text.toString()
                if (nuevoNumero) {
                    tvDisplay.text = if (textoBoton == ".") "0." else textoBoton
                    nuevoNumero = false
                } else {
                    if (textoBoton == "." && tvDisplay.text.contains(".")) return@setOnClickListener
                    tvDisplay.append(textoBoton)
                }
            }
        }

        findViewById<Button>(R.id.btnSuma).setOnClickListener { setOperador("+") }
        findViewById<Button>(R.id.btnResta).setOnClickListener { setOperador("-") }
        findViewById<Button>(R.id.btnMult).setOnClickListener { setOperador("*") }
        findViewById<Button>(R.id.btnDiv).setOnClickListener { setOperador("/") }

        findViewById<Button>(R.id.btnReset).setOnClickListener {
            tvDisplay.text = "0"
            primerNumero = 0.0
            operacion = ""
            nuevoNumero = true
        }

        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            if (operacion.isNotEmpty()) {
                val segundoNumero = tvDisplay.text.toString().toDoubleOrNull() ?: 0.0
                var resultado = 0.0
                when (operacion) {
                    "+" -> resultado = primerNumero + segundoNumero
                    "-" -> resultado = primerNumero - segundoNumero
                    "*" -> resultado = primerNumero * segundoNumero
                    "/" -> resultado = if (segundoNumero != 0.0) primerNumero / segundoNumero else 0.0
                }
                tvDisplay.text = if (resultado % 1 == 0.0) resultado.toInt().toString() else resultado.toString()
                operacion = ""
                nuevoNumero = true
            }
        }
    }

    private fun setOperador(op: String) {
        primerNumero = tvDisplay.text.toString().toDoubleOrNull() ?: 0.0
        operacion = op
        nuevoNumero = true
    }
}