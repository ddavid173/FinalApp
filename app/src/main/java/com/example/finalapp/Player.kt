package com.example.finalapp

import android.content.res.Resources
import android.widget.ImageView
import java.lang.Math.abs


/**
 * Player Class.
 */

class Player(private val image: ImageView) {
    var lastx = 0.0f
    var goDown = false
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    init {
        image.translationX = 0f//(screenWidth/20).toFloat()
        image.translationY = 0f//(screenHeight / 6).toFloat()
    }

    /**
     * update properties for the game object
     * when the player touches the screen, position the player bitmap there
     */
    fun updateTouch(start: Float, end: Float) {
        if (image.translationX + (end - start).toFloat() < 0){
                if ((end - start) > 0){
                    image.translationX += (end - start).toFloat()
                }
        } else if (image.translationX + (end - start).toFloat() > (screenWidth - image.width)) {
                if ((end - start) < 0) {
                    image.translationX += (end - start).toFloat()
                }
        } else {
            image.translationX += (end - start).toFloat()
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

    fun reset(){
        image.translationX = 0f
    }

    fun collided(plat: Platform): Boolean {
        val diff = abs(((image.translationY) + screenHeight) - plat.y - image.height - 50)
        println(diff)
        return if (goDown) {
            diff < 5
        } else {
            false
        }
    }

}