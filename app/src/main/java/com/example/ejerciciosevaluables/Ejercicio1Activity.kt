package com.example.ejerciciosevaluables

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btnAbrirUrl = findViewById<Button>(R.id.btnAbrirUrl)

        btnAbrirUrl.setOnClickListener {
            var url = etUrl.text.toString().trim()

            if (url.isEmpty()) {
                Toast.makeText(this, "Por favor, introduce una URL", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://$url"
            }

            if (URLUtil.isValidUrl(url)) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Introduce una URL válida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}