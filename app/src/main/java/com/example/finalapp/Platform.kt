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
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    init {
        spawn()
    }

    /**
     * update properties for the game object
     * when the player touches the screen, position the player bitmap there
     */
    fun updateTouch(y_move: Float) {
        image.translationY += (y_move)
        y = image.translationY + image.height

    }

    fun spawn(){
        image.translationX = Random.nextInt(30, screenWidth - image.width).toFloat()
        image.translationY = 750f
    }

    fun inVisible(): Boolean {
        return image.visibility == View.VISIBLE
    }

    fun reset(){
        image.translationX = 0f
        image.translationY= 0f
        image.visibility = View.GONE
    }

}