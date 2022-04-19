package com.example.finalapp

import android.content.res.Resources
import android.view.View
import android.widget.ImageView
import kotlin.random.Random


/**
 * Player Class.
 */

class Platform(private val image: ImageView) {
    var y = 0f
    var x = 0f
    private lateinit var below: Platform
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    fun setUp (belowPlat: Platform, first: Boolean){
        below = belowPlat
        image.translationX = Random.nextInt(30, screenWidth - image.width - 100).toFloat()
        x = image.translationX
        if (first) {
            image.translationY = ((screenHeight / 4) * -1).toFloat()
        } else {
            image.translationY = below.y - screenHeight / 4
        }
        y = image.translationY
        image.visibility = View.VISIBLE
    }

    fun updateTouch(y_move: Int) {
        image.translationY += y_move
        y = image.translationY
    }

    fun reset(){
        image.translationX = Random.nextInt(30, screenWidth - image.width - 100).toFloat()
        image.translationY = below.y - screenHeight / 4
        y = image.translationY
        x = image.translationX
    }

    fun onBotton(): Boolean {
        return (image.translationY > 0)
    }


}