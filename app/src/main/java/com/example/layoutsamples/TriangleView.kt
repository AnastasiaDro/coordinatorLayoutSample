package com.example.layoutsamples;

import android.animation.ValueAnimator
import android.content.Context;
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Point
import android.text.Editable
import android.util.AttributeSet;
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*

class TriangleView(context: Context, attrs: AttributeSet) : View(context, attrs ) {

    private var mColor = 0
    private var isAnimat = true
    private var path = Path()
    private var triangleWidth = 0
    private var trianglePaint = Paint()
    private val mAnimation = AnimationUtils.loadAnimation(context, R.anim.rotating)
    private var mSpeed = 2000


            init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TriangleView,
            0, 0
        ).apply {
            try {
                mColor = getColor(R.styleable.TriangleView_color, 0)
                mSpeed = getInt(R.styleable.TriangleView_speed, 2000)
                isAnimat = getBoolean(R.styleable.TriangleView_isAnimated, true)
                triangleWidth = getInteger(R.styleable.TriangleView_triangleSize, 200)
                trianglePaint.color = mColor
                mAnimation.duration = mSpeed.toLong()
                if (isAnimat) startAnimation()
            } finally {
                recycle()
            }
        }
    }

    fun isAnimated(): Boolean {
        return isAnimat
    }

    fun setAnimated(isAnimate: Boolean) {
       isAnimat = isAnimate
        invalidate()
    }

    fun getColor(): Int {
        return mColor
    }

    private fun setColor(newColor: Int) {
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
        mAnimation.duration = mSpeed.toLong()
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
        trianglePaint.color = mColor
        canvas.drawPath(path, trianglePaint)
    }

    fun startAnimation() {
        this.startAnimation(mAnimation)
    }

    fun stopAnimation() {
        this.clearAnimation()
    }


    fun changeColor(text: Editable) {
        when (text.toString().lowercase(Locale.getDefault())) {
            "yellow" -> setColor(resources.getColor(R.color.yellow))
            "green" -> setColor(resources.getColor(R.color.green))
            "blue"  -> setColor(resources.getColor(R.color.blue))
            else -> Toast.makeText(context, "Неизвестный цвет", Toast.LENGTH_LONG).show()
        }
    }

    fun applyNextSpeed() {
        when (mSpeed) {
            500 -> setSpeed(2000)
            2000 -> setSpeed(3500)
            3500 -> setSpeed(500)
            else -> Unit
        }

    }

}
