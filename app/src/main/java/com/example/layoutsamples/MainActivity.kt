package com.example.layoutsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var triangleView : TriangleView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_view_activity)
        triangleView = findViewById(R.id.triangle)
    }

    override fun onResume() {
        super.onResume()
        triangleView.startAnimation()
    }

}