package com.example.finalapp

import android.content.res.Resources
import android.view.View
import android.widget.ImageView
import kotlin.random.Random


/**
 * Player Class.
 */

class Platform(private val image: ImageView) {
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    init {
        spawn()
    }

    /**
     * update properties for the game object
     * when the player touches the screen, position the player bitmap there
     */
    fun updateTouch(y_move: Int) {
        image.translationY += (y_move).toFloat()
    }

    fun spawn(){
        image.translationX = Random.nextInt(30, screenWidth - image.width - 60).toFloat()
        image.translationY = (image.height).toFloat()
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