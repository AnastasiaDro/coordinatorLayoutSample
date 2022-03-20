package com.example.layoutsamples;

import android.animation.ValueAnimator
import android.content.Context;
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Point
import android.util.AttributeSet;
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation

class TriangleView(context: Context, attrs: AttributeSet) : View(context, attrs ) {
    private var mSpeed = 0
    private var mColor = 0
    private var isAnimat = true
    private var path = Path()
    private var triangleWidth = 0
    private var trianglePaint = Paint()
    private var size = 0
    private val mAimation = AnimationUtils.loadAnimation(context, R.anim.rotating)


    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TriangleView,
            0, 0
        ).apply {
            try {
                mColor = getColor(R.styleable.TriangleView_color, 0)
                mSpeed = getInteger(R.styleable.TriangleView_speed, 100)
                isAnimat = getBoolean(R.styleable.TriangleView_isAnimated, true)
                triangleWidth = getInteger(R.styleable.TriangleView_triangleSize, 200)
                trianglePaint.color = mColor
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
        drawTriangle(canvas!!)
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Try for a width based on our minimum
        val minw: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val w: Int = View.resolveSizeAndState(minw, widthMeasureSpec, 1)

        // Whatever the width ends up being, ask for a height that would let the pie
        // get as big as it can
        val minh: Int = View.MeasureSpec.getSize(w) - triangleWidth.toInt() + paddingBottom + paddingTop
        val h: Int = View.resolveSizeAndState(
            View.MeasureSpec.getSize(w) - triangleWidth.toInt(),
            heightMeasureSpec,
            0
        )

        setMeasuredDimension(w, h)
    }


    private fun drawTriangle(canvas: Canvas)
    {
        val b = Point(650, 300)
        val c = Point(550, 40)

        path.fillType = Path.FillType.WINDING
        path.lineTo(b.x.toFloat(), b.y.toFloat())
        path.lineTo(c.x.toFloat(), c.y.toFloat())
        canvas.drawPath(path, trianglePaint)
    }

    fun startAnimation() {
        startAnimation(mAimation)
    }

    fun stopAnimation() {
        stopAnimation(mAimation)
    }


}
