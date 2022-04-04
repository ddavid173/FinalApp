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

class SecondActivity : AppCompatActivity() {

    lateinit var backButton: Button
    private lateinit var binding: ActivitySecondBinding

//    private var mVelocityTracker: VelocityTracker? = null

    private var character = findViewById<ImageView>(R.id.character)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        backButton = findViewById(R.id.button)

        backButton.setOnClickListener {
            toMain()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
//        if (action == MotionEvent.ACTION_DOWN) {
//            tx = event.x
//        }
        if (action == MotionEvent.ACTION_MOVE){
            val tx = event.x
            character.x = tx
        }
        return true
    }



    private fun toMain() {
        val intent = Intent(this,MainActivity::class.java).apply {}
        startActivity(intent)
    }
}