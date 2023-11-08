package com.pmdm.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

        initListeners()

        initUI()

    }

    private lateinit var viewmale:CardView
    private lateinit var viewfemale:CardView

    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider

    private lateinit var tvAge:CardView
    private lateinit var tvPeso:CardView
    private lateinit var fabmAge:FloatingActionButton
    private lateinit var fabpAge:FloatingActionButton
    private lateinit var fabmPeso:FloatingActionButton
    private lateinit var fabpPeso:FloatingActionButton

    private lateinit var textPeso: TextView
    private lateinit var textEdad: TextView

    private lateinit var calcButton: AppCompatButton

    private var peso: Int = 50
    private var edad: Int = 16

    private var ismaleSeclected :Boolean = true

    private fun initComponents() {
        viewmale = findViewById(R.id.viewmale)
        viewfemale = findViewById(R.id.viewfemale)

        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)

        tvAge = findViewById(R.id.tvAge)
        tvPeso = findViewById(R.id.tvPeso)
        fabmAge = findViewById(R.id.fabmAge)
        fabpAge = findViewById(R.id.fabpAge)
        fabmPeso = findViewById(R.id.fabmPeso)
        fabpPeso = findViewById(R.id.fabpPeso)

        textEdad = findViewById(R.id.textEdad)
        textPeso = findViewById(R.id.textPeso)

        calcButton = findViewById(R.id.calcButton)

    }

    private fun initListeners() {
        viewmale.setOnClickListener{
            ismaleSeclected = true
            setGenderColor()
        }

        viewfemale.setOnClickListener{
            ismaleSeclected = false
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
        tvHeight.text = value.toString()
        tvHeight.text = (DecimalFormat("#.##").format(value))
        }

        fabmPeso.setOnClickListener {
            peso -= 1
            setPeso()

        }

        fabpPeso.setOnClickListener {
            peso += 1
            setPeso()
        }

        fabmAge.setOnClickListener {
            edad -= 1
            setEdad()
        }

        fabpAge.setOnClickListener {
            edad += 1
            setEdad()
        }

        calcButton.setOnClickListener {
            calculateIMC()
        }
    }

    private fun setGenderColor() {
        viewmale.setCardBackgroundColor(getBackgroundColor(ismaleSeclected))
        viewfemale.setCardBackgroundColor(getBackgroundColor(!ismaleSeclected))
    }
    private fun getBackgroundColor(isComponentSelected: Boolean): Int {

        val colorReference = if(isComponentSelected) {
            R.color.bg_comp_sel
        } else {
            R.color.bg_comp
        }
        return ContextCompat.getColor(this,colorReference)
    }

    private fun setPeso() {
        textPeso.text = peso.toString()
    }
    private fun setEdad() {
        textEdad.text = edad.toString()
    }

    private fun initUI() {
        setGenderColor()
        setEdad()
        setPeso()
    }

    private fun calculateIMC() {

        var resultadoIMC: Double = 0.0

        var numIMC: String = (DecimalFormat("#.##").format(resultadoIMC))
        //Toast.makeText(this, "$numIMC", Toast.LENGTH_SHORT).show() - PROBAR

        var pesoIMC = textPeso.text.toString().toDouble()
        var alturaIMC = tvHeight.text.toString().toDouble()

        resultadoIMC = pesoIMC / ((alturaIMC/100) * alturaIMC)

        var desc: String = ""
        var titulo: String = ""

        when (resultadoIMC) {
            in 0.0..18.5 -> {
                desc = getString(R.string.TextInfrapeso)
                titulo = getString(R.string.Infrapeso)
            }

            in 18.6..24.9 -> {
                desc = getString(R.string.TextNormal)
                titulo = getString(R.string.PesoNormal)
            }

            in 25.00..29.9 -> {
                desc = getString(R.string.TextSobrepeso)
                titulo = getString(R.string.Sobrepeso)
            }

            in 30.00..Double.MAX_VALUE -> {
                desc = getString(R.string.TextObesidad)
                titulo = getString(R.string.Obesidad)
            }

            else -> {
            }
        }

        val df = DecimalFormat("#.##")
        val result = df.format(resultadoIMC)




        val intent = Intent(this, ImcResultActivity::class.java)
        intent.putExtra("Título", titulo)
        intent.putExtra("Descripción", desc)
        intent.putExtra("Resultado", result)
        startActivity(intent)
    }




}