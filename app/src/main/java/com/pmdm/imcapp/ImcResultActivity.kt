package com.pmdm.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import org.w3c.dom.Text

class ImcResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)

        initComponents()

        initListeners()

        initUI()

    }

    private lateinit var textCorporal: TextView
    private lateinit var resultadoIMC: TextView
    private lateinit var descripcion: TextView

    private lateinit var recalcButton: AppCompatButton

    private fun initComponents() {
        textCorporal = findViewById(R.id.textCorporal)
        resultadoIMC = findViewById(R.id.resultadoIMC)
        descripcion = findViewById(R.id.descripcion)

        recalcButton = findViewById(R.id.recalcButton)
    }

    private fun initListeners() {
        recalcButton.setOnClickListener {
            volverInicio()
        }
    }

    private fun initUI() {
        val titulo:String =intent.extras?.getString("Título").orEmpty()
        textCorporal.text = titulo
        val res:String? = intent.extras?.getString("Resultado")
        resultadoIMC.text = res.toString()
        val desc = intent.extras?.getString("Descripción").orEmpty()
        descripcion.text = desc
    }

    private fun volverInicio() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}