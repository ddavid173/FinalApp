package com.example.finalapp

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock.sleep
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapp.databinding.ActivitySecondBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GameActivity : AppCompatActivity() {

    lateinit var backButton: FloatingActionButton
    private lateinit var binding: ActivitySecondBinding
    private val fps = 60
    private val sleepTime = 1000 / fps
    var running = true

//    private var mVelocityTracker: VelocityTracker? = null

    lateinit var character: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
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

    fun game(){
        while (running) {
            character.x += 20
            sleep(sleepTime.toLong())
        }
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
        var start: Float
        start = if (action == MotionEvent.ACTION_DOWN) {
            character.x
        } else {
            (0).toFloat()
        }
        if (action == MotionEvent.ACTION_MOVE){
            val tx = event.x
            character.x = tx - start
        }
        return true
    }


    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }

    fun update(){
        //todo
    }

}