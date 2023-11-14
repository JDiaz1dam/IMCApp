package com.pmdm.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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

    private lateinit var tvAge:TextView
    private lateinit var tvPeso:TextView
    private lateinit var fabmAge:FloatingActionButton
    private lateinit var fabpAge:FloatingActionButton
    private lateinit var fabmPeso:FloatingActionButton
    private lateinit var fabpPeso:FloatingActionButton

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
        tvHeight.text = (DecimalFormat("#.##").format(value) + "cm")
        }

        fabmAge.setOnClickListener {

        }

        fabpAge.setOnClickListener {

        }

        fabmPeso.setOnClickListener {

        }

        fabpPeso.setOnClickListener {

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

    private fun initUI() {
        setGenderColor()
    }

}