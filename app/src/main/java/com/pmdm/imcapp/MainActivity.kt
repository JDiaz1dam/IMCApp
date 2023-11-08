package com.pmdm.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

        initListeners()


    }

    private lateinit var viewmale:CardView
    private lateinit var viewfemale:CardView

    private fun initComponents() {
        viewmale = findViewById(R.id.viewmale)
        viewfemale = findViewById(R.id.viewfemale)
    }

    private fun initListeners() {

    }

}