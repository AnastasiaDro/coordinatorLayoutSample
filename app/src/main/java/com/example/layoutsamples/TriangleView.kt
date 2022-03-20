package com.example.layoutsamples;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View

class TriangleView(context: Context, attrs: AttributeSet) : View(context, attrs ) {
    private var mSpeed = 0
    private var color = 0
    private var isAnimat = true

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TriangleView,
            0, 0
        ).apply {
            try {
                mSpeed = getInteger(R.styleable.TriangleView_speed, 100)
                color = getColor(R.styleable.TriangleView_color, 0)
                isAnimat = getBoolean(R.styleable.TriangleView_isAnimated, true)
            } finally {
                recycle()
            }
        }
    }

    fun isAnimated(): Boolean {
        return isAnimated()
    }

    fun setAnimated(isAnimate: Boolean) {
       isAnimat = isAnimate
        invalidate()
    }

    fun getColor(): Int {
        return color
    }

    fun setColor(newColor: Int) {
        color = newColor
        invalidate()
    }

    fun getSpeed(): Int {
        return mSpeed
    }

    fun setSpeed(newSpeed: Int) {
        mSpeed = newSpeed
        invalidate()
    }

}
