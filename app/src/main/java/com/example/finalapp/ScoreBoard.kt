package com.example.finalapp

import android.content.res.Resources
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random


/**
 * Player Class.
 */

class ScoreBoard(private val scores: TextView) {
    private var score = 0
    fun setUp (belowPlat: ScoreBoard, first: Boolean){
        scores.text = "0"
    }

    fun update() {
        score += 1
        scores.text = score.toString()
    }

}