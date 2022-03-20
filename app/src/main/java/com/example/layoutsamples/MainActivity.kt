package com.example.layoutsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var triangleView : TriangleView
    lateinit var animationBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_view_activity)
        triangleView = findViewById(R.id.triangle)
        animationBtn = findViewById<Button?>(R.id.startAnimateBtn).apply {
            setOnClickListener {
                triangleView.startAnimation()
        } }
    }

}