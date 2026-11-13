package com.example.ejerciciosevaluables

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnEj1).setOnClickListener {
            startActivity(Intent(this, Ejercicio1Activity::class.java))
        }
        findViewById<Button>(R.id.btnEj2).setOnClickListener {
            startActivity(Intent(this, Ejercicio2Activity::class.java))
        }
        findViewById<Button>(R.id.btnEj3).setOnClickListener {
            startActivity(Intent(this, Ejercicio3Activity::class.java))
        }
        findViewById<Button>(R.id.btnEj4).setOnClickListener {
            startActivity(Intent(this, Ejercicio4Activity::class.java))
        }
        findViewById<Button>(R.id.btnEj5).setOnClickListener {
            startActivity(Intent(this, Ejercicio5Activity::class.java))
        }
        findViewById<Button>(R.id.btnEj6).setOnClickListener {
            startActivity(Intent(this, Ejercicio6Activity::class.java))
        }
    }
}