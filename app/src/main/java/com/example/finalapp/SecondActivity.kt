package com.example.finalapp

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import com.example.finalapp.databinding.ActivitySecondBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Timer
import kotlin.concurrent.schedule

class SecondActivity : AppCompatActivity() {

    lateinit var backButton: FloatingActionButton
    private lateinit var binding: ActivitySecondBinding

//    private var mVelocityTracker: VelocityTracker? = null

    lateinit var character: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        //character
        character = binding.character

        // back button
        backButton = findViewById(R.id.fab)
        backButton.setOnClickListener {
            toMain()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
        if (action == MotionEvent.ACTION_MOVE){
            val tx = event.x
            character.x = tx
        }
//        else if (action == MotionEvent.ACTION_DOWN){
//            game()
//        }
        return true
    }

//    private fun game(){
//        var lastIterationTime = System.currentTimeMillis()
////        while (character.y < 800){
//        for (i in 1..100000){
//            val now = System.currentTimeMillis()
//            val timePassed = now - lastIterationTime
//            if (timePassed > 100){
//                rising()
//                lastIterationTime = System.currentTimeMillis()
//            }
//        }
//    }


    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }

    private fun rising(){
        character.y = character.y - 1
    }

}