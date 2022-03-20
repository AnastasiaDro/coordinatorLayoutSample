package com.example.layoutsamples;

import android.content.Context;
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet;
import android.view.View

class TriangleView(context: Context, attrs: AttributeSet) : View(context, attrs ) {
    private var mSpeed = 0
    private var mColor = 0
    private var isAnimat = true
    private var canvas = Canvas()
    private lateinit var trianglePaint: Paint

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TriangleView,
            0, 0
        ).apply {
            try {
                mSpeed = getInteger(R.styleable.TriangleView_speed, 100)
                mColor = getColor(R.styleable.TriangleView_color, 0)
                isAnimat = getBoolean(R.styleable.TriangleView_isAnimated, true)
                trianglePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                    style = Paint.Style.FILL
                    color = mColor
                }
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
        return mColor
    }

    fun setColor(newColor: Int) {
        mColor = newColor
        invalidate()
    }

    fun getSpeed(): Int {
        return mSpeed
    }

    fun setSpeed(newSpeed: Int) {
        mSpeed = newSpeed
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas.apply {
            drawTr
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Try for a width based on our minimum
        val minw: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val w: Int = View.resolveSizeAndState(minw, widthMeasureSpec, 1)

        // Whatever the width ends up being, ask for a height that would let the pie
        // get as big as it can
        val minh: Int = View.MeasureSpec.getSize(w) - triangleWait.toInt() + paddingBottom + paddingTop
        val h: Int = View.resolveSizeAndState(
            View.MeasureSpec.getSize(w) - textWidth.toInt(),
            heightMeasureSpec,
            0
        )

        setMeasuredDimension(w, h)

    }

}
