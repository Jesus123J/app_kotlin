package com.utp.app_kotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
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
        editTextPrecio.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                val texto = s.toString()
                if (!texto.matches(Regex("^\\d+(\\.\\d+)?$"))) {
                   println("Error")
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
        button.setOnClickListener(View.OnClickListener {
            calca()
        })
    }

  private fun calca() {
      try {

          val monto = editTextPrecio.text.toString().toDouble()
          val montoTas = editTextTas.text.toString().toDouble()
          val time = editTextTime.text.toString().toDouble()
          println("amount -> $montoTas ")
          val tasaEfectivaMensual = (1 + montoTas).pow(1 / 12.0) - 1

          println(tasaEfectivaMensual)
          Log.i("Informacion" , " Cantidad")
          texView.text = "bonbon $tasaEfectivaMensual"


      } catch (e: NumberFormatException) {

      }
  }
}