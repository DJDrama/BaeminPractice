package com.dj.baeminpractice.ui

import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.core.widget.NestedScrollView


//https://medium.com/better-programming/recyclerview-expanded-1c1be424282c

fun View.expand(scrollView: NestedScrollView?=null) {
    measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    val actualHeight = measuredHeight
    layoutParams.height = 0
    visibility = View.VISIBLE
    val animation: Animation = object : Animation() {
        override fun applyTransformation(
            interpolatedTime: Float,
            t: Transformation
        ) {
            layoutParams.height =
                if (interpolatedTime == 1f) ViewGroup.LayoutParams.WRAP_CONTENT else (actualHeight * interpolatedTime).toInt()
            requestLayout()
        }
    }
   /** REPEATING FOR VIDEO **/
    animation.setAnimationListener(object: Animation.AnimationListener{
        override fun onAnimationRepeat(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            //set visible when animation ends
            scrollView?.run{
                smoothScrollTo(0, bottom)
            }
        }

        override fun onAnimationStart(animation: Animation?) {
        }

    })
    animation.duration = (actualHeight / context.resources.displayMetrics.density).toLong()
    startAnimation(animation)
}

fun View.collapse() {
    val actualHeight: Int = measuredHeight
    val animation: Animation = object : Animation() {
        override fun applyTransformation(
            interpolatedTime: Float,
            t: Transformation?
        ) {
            if (interpolatedTime == 1f) {
                visibility = View.GONE
            } else {
                layoutParams.height =
                    actualHeight - (actualHeight * interpolatedTime).toInt()
                requestLayout()
            }
        }
    }

    animation.duration =
        (actualHeight / context.resources.displayMetrics.density).toLong()
    startAnimation(animation)
}