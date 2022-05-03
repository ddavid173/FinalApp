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
    private var space = screenHeight / 4

    fun setUp (belowPlat: Platform, first: Boolean){
        if (GameActivity.Toggle.bool) {
            space = (screenHeight / 2.5).toInt()
        }
        below = belowPlat
        image.translationX = Random.nextInt(30, screenWidth - image.width - 100).toFloat()
        x = image.translationX
        if (first) {
            image.translationY = ((space) * -1).toFloat()
        } else {
            image.translationY = below.y - space
        }
        y = image.translationY
        image.visibility = View.VISIBLE
    }

    fun updateTouch(y_move: Int) {
        if (GameActivity.Toggle.bool){ // makes it go faster when hardmode is on?
            image.translationY += y_move * 3
        }
        image.translationY += y_move
        y = image.translationY
    }

    fun reset(){
        if (GameActivity.Toggle.bool) {
            space = (screenHeight / 2.5).toInt()
        }
        image.translationX = Random.nextInt(30, screenWidth - image.width - 100).toFloat()
        image.translationY = below.y - space
        y = image.translationY
        x = image.translationX
    }

    fun onBotton(): Boolean {
        return (image.translationY > 0)
    }


}