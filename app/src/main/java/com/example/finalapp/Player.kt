package com.example.finalapp

import android.content.res.Resources
import android.widget.ImageView


/**
 * Player Class.
 */

class Player(private val image: ImageView) {
    var lastx = 0.0f
    private var goDown = false
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels

    init {
        image.translationX = 0f//(screenWidth/20).toFloat()
        image.translationY = 0f//(screenHeight / 6).toFloat()
    }

    /**
     * update properties for the game object
     * when the player touches the screen, position the player bitmap there
     */
    fun updateTouch(start: Float, end: Float) {
        if (image.translationX + (end - start) < 0){
                if ((end - start) > 0){
                    image.translationX += (end - start)
                }
        } else if (image.translationX + (end - start) > (screenWidth - image.width)) {
                if ((end - start) < 0) {
                    image.translationX += (end - start)
                }
        } else {
            image.translationX += (end - start)
        }
    }
    
    fun jump(move: Double){
        image.translationY -= move.toFloat()
        if (move < 0) {
            goDown = true
        } else if (move > 0) {
            goDown = false
        }
    }

    fun dead(): Boolean {
        return image.translationY > 300
    }

    fun collided(plat: Platform): Boolean {
        val diffY = image.translationY - plat.y
        val diffX = image.translationX - plat.x
        return if (goDown) {
            (diffY < 15) && (diffY > -15) && (diffX < image.width / 2) && (diffX > -1 * image.width / 2)
        } else {
            false
        }
    }

}