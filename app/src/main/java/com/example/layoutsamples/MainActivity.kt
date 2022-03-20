package com.example.layoutsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var triangleView : TriangleView
    lateinit var startAnimationBtn : Button
    lateinit var stopAnimationBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_view_activity)
        triangleView = findViewById(R.id.triangle)
        startAnimationBtn = findViewById<Button?>(R.id.startAnimationBtn).apply {
            setOnClickListener {
                triangleView.startAnimation()
        } }

        stopAnimationBtn = findViewById<Button?>(R.id.stopAnimationBtn).apply {
            setOnClickListener {
                triangleView.stopAnimation()
            } }
    }

}