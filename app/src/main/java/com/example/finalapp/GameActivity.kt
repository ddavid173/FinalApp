package com.example.finalapp

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapp.databinding.ActivitySecondBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.concurrent.thread

class GameActivity : AppCompatActivity() {


    lateinit var backButton: FloatingActionButton
    private lateinit var binding: ActivitySecondBinding

    private val a = 9.8
    private val v0 = 10
    private val fps = 60
    private val sleepTime = 1000 / fps
    private var t = 0
    var running = true

//    private var mVelocityTracker: VelocityTracker? = null

    lateinit var character: Player
    lateinit var platform1: Platform
    lateinit var platform2: Platform
    lateinit var platform3: Platform

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        //character
        character = Player(binding.character)
        platform1 = Platform(binding.platform1)

        // back button
        backButton = findViewById(R.id.fab)
        thread { // launch a new coroutine and continue
            game()
        }
        backButton.setOnClickListener {
                toMain()
        }
    }

    private fun game() {
        while (running) {
            platform1.updateTouch(v0*t - 0.5 * a * t * t)
            t += sleepTime
            Thread.sleep(sleepTime.toLong())
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
        if (action == MotionEvent.ACTION_DOWN){
            val tx = event.x
            character.lastx = tx
        }
        if (action == MotionEvent.ACTION_MOVE){
            val tx = event.x
            character.updateTouch(character.lastx, tx)
            character.lastx = tx
        }
        return true
    }


    private fun toMain() {
        finish()
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }

    private fun reset(){
        running = false
        character.reset()
        platform1.reset()

    }

}