package com.example.ejerciciosevaluables

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio3TargetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tipo = intent.getIntExtra("TIPO_LAYOUT", 1)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        val tvHeader = TextView(this).apply {
            text = "PROGRAMACIÓN MULTIMEDIA"
            textSize = 18f
            setTextColor(Color.BLACK)
            setBackgroundColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 32, 0, 32)
        }
        root.addView(tvHeader)

        val layoutAnidado = when (tipo) {
            1 -> crearLayoutBandera(Color.BLUE)
            2 -> crearLayoutBandera(Color.GREEN)
            else -> crearLayoutMatrizRoja()
        }
        root.addView(layoutAnidado)

        setContentView(root)
    }

    private fun crearLayoutBandera(colorExtremo: Int): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            weightSum = 3f

            addView(LinearLayout(context).apply {
                layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                setBackgroundColor(colorExtremo)
            })
            addView(LinearLayout(context).apply {
                layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                setBackgroundColor(Color.WHITE)
            })
            addView(LinearLayout(context).apply {
                layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                setBackgroundColor(colorExtremo)
            })
        }
    }

    private fun crearLayoutMatrizRoja(): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            weightSum = 2f

            addView(LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
                weightSum = 3f
                addView(LinearLayout(context).apply { layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f); setBackgroundColor(Color.RED) })
                addView(LinearLayout(context).apply { layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f); setBackgroundColor(Color.WHITE) })
                addView(LinearLayout(context).apply { layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f); setBackgroundColor(Color.RED) })
            })

            addView(LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
                weightSum = 3f
                addView(LinearLayout(context).apply { layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f); setBackgroundColor(Color.WHITE) })
                addView(LinearLayout(context).apply { layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f); setBackgroundColor(Color.RED) })
                addView(LinearLayout(context).apply { layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f); setBackgroundColor(Color.WHITE) })
            })
        }
    }
}