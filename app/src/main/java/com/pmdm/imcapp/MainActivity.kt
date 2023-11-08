package com.pmdm.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

        initListeners()

        //initUI()

    }

    private lateinit var viewmale:CardView
    private lateinit var viewfemale:CardView

    private lateinit var tvHeight:CardView
    private lateinit var rsHeight:RangeSlider

    private var ismaleSeclected :Boolean = true

    private fun initComponents() {
        viewmale = findViewById(R.id.viewmale)
        viewfemale = findViewById(R.id.viewfemale)

        //ME PETA tvHeight = findViewById(R.id.tvHeight)
        //ME PETA rsHeight = findViewById(R.id.rsHeight)

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

        //rsHeight.addOnChangeListener { _, value, _ ->
        //tvHeight.text = value.toString()
        //tvHeight.text = (DecimalFormat("#.##").format(value) + "cm"
        //}

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