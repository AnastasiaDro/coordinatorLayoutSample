package com.example.layoutsamples;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View

class TriangleView(context: Context, attrs: AttributeSet) : View(context, attrs ) {
    var mSpeed = 0
    var color = 0
    var isAnimat = true

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

}
