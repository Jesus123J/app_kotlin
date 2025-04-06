package com.utp.app_kotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.pow
import kotlin.math.pow

class Main : AppCompatActivity() {

    private lateinit var editTextPrecio : EditText
    private lateinit var editTextTas : EditText
    private lateinit var editTextTime : EditText
    private lateinit var button: Button
    private lateinit var texView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.mainlayout)
//
//        editTextPrecio = this.findViewById(R.id.editTextPrecio)
//        editTextTas = this.findViewById(R.id.editTextTasaAnual)
//        editTextTime = this.findViewById(R.id.editTextTiempo)
//        button = this.findViewById(R.id.button)
//        texView = this.findViewById(R.id.textView9)
//
//        button.setOnClickListener(View.OnClickListener {
//             calca()
//        })
    }

//
//    fun calca() {
//        try {
//            val monto = editTextPrecio.text.toString().toDouble()
//            val montoTas = editTextTas.text.toString().toDouble()
//            val time = editTextTime.text.toString().toDouble()
//
//            val tasaEfectivaMensual = pow(1 - (montoTas / 100) , 1/12.0 ) - 1
//
//            println("Tasa efectiva mensual $tasaEfectivaMensual")
//
//            texView.text = "${tasaEfectivaMensual}"
//        } catch (e: NumberFormatException) {
//            texView.text = "Por favor, ingresa valores válidos."
//        }
//    }
}