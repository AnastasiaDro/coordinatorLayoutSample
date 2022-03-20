package com.example.layoutsamples

import android.view.View
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout

class MyCustomBehavior : CoordinatorLayout.Behavior<ImageView>() {
    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: ImageView,
        dependency: View
    ): Boolean {
        return super.layoutDependsOn(parent, child, dependency)
    }

}