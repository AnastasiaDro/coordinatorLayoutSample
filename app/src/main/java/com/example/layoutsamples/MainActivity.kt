package com.example.layoutsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    lateinit var triangleView: TriangleView
    lateinit var changeTriangleColorBtn: Button
    lateinit var colorEditText: EditText
    lateinit var switch: SwitchCompat


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_view_activity)
        triangleView = findViewById(R.id.triangle)
        switch = findViewById(R.id.animationSwitch)
        colorEditText = findViewById(R.id.colorEditText)
        changeTriangleColorBtn = findViewById<Button?>(R.id.changeTriangleColorBtn).apply {
            setOnClickListener {
                triangleView.changeColor(colorEditText.text)
            }
        }



        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) triangleView.startAnimation() else triangleView.stopAnimation()
        }
    }

}