package com.example.layoutsamples

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.size
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyCustomBehavior(context: Context, attributeSet: AttributeSet): CoordinatorLayout.Behavior<View>(context, attributeSet) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is AppBarLayout
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        val scaleFactor =
//        child.scaleX = scaleFactor
//        child.scaleY = scaleFactor
        return true
    }

    private fun getViewOffset(parent: CoordinatorLayout, view: View): Float {
        var maxOffset = 0f
        val dependencies = parent.getDependencies(view)
        dependencies.forEach { dependency ->
            if (dependency is AppBarLayout) {
                maxOffset = (dependency.translationY - dependency.height)
            }
        }
        return maxOffset
    }
}