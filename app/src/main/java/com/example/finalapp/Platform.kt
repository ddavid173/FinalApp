package com.example.finalapp

import android.content.res.Resources
import android.widget.ImageView


/**
 * Player Class.
 */

class Platform(private val image: ImageView, private val xIn: Float, private val yIn: Float) {
    var x = image.x
    var y = image.y
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    init {
        x = xIn
        y = yIn
    }

    /**
     * update properties for the game object
     * when the player touches the screen, position the player bitmap there
     */
    fun updateTouch(y_move: Int) {
        y += (y_move).toFloat()
    }

}