package com.example.finalapp

import android.content.res.Resources
import android.widget.ImageView


/**
 * Player Class.
 */

class Player(private val image: ImageView) {
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    init {
        image.x = (screenWidth/2).toFloat()
        image.y = (screenHeight / 5).toFloat()
    }

    /**
     * update properties for the game object
     * when the player touches the screen, position the player bitmap there
     */
    fun updateTouch(touch_x: Int) {
        image.x = (touch_x - screenWidth / 2).toFloat()
    }

}