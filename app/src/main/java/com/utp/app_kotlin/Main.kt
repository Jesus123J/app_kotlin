package com.utp.app_kotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.log
import java.lang.Math.pow
import kotlin.math.pow

class Main : AppCompatActivity() {

    private lateinit var editTextPrecio : EditText
    private lateinit var editTextTas : EditText
    private lateinit var editTextTime : EditText
    private lateinit var button: Button
    private lateinit var texView: TextView
    private lateinit var textViewMensual: TextView
    private lateinit var checkBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  supportActionBar?.hide()
        supportActionBar?.title = "Glovo KVB"
        setContentView(R.layout.mainlayout)
        editTextPrecio = this.findViewById(R.id.editTextPrice)
        editTextTas = this.findViewById(R.id.editTextTasaAnual)
        editTextTime = this.findViewById(R.id.editTextTime)
        button = this.findViewById(R.id.button)
        texView = this.findViewById(R.id.textViewShowTasaMensual)
        textViewMensual = this.findViewById(R.id.textViewCuotaMensual)
        checkBox = this.findViewById(R.id.checkBox)
        checkBox.setOnClickListener(View.OnClickListener {
            if (editTextPrecio.text.isNotBlank()) {
                val textPre = editTextPrecio.text.toString().toDouble() / 100
                editTextPrecio.setText(textPre.toString())

            }

            if (editTextTas.text.isNotBlank()){
                val text = editTextTas.text.toString().toDouble() / 100
                editTextTas.setText(text.toString())

            }
        })
        button.setOnClickListener(View.OnClickListener {
            main()
        })
    }


    fun calcularTEM(tea: Double): Double {
        return (1 + tea).pow(1.0 / 12) - 1
    }

    private fun calcularCuotaMensual(precio: Double, tasaMensual: Double, tiempo: Int): Double {
        return precio * (tasaMensual * (1 + tasaMensual).pow(tiempo) / ((1 + tasaMensual).pow(tiempo) - 1))
    }

    fun main() {

        val precio = editTextPrecio.text.toString().toDouble()
        val tea = editTextTas.text.toString().toDouble()

        val tiempo = editTextTime.text.toString().toInt()

        val tasaMensual = calcularTEM(tea)
        val cuotaMensual = calcularCuotaMensual(precio, tasaMensual, tiempo)

        texView.text = "%.6f".format(tasaMensual)
        textViewMensual.text = "%.2f".format(cuotaMensual)
    }

}