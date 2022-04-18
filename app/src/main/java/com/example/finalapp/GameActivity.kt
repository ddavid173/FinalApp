package com.example.finalapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapp.databinding.ActivityGameBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.concurrent.thread

class GameActivity : AppCompatActivity() {


    lateinit var backButton: FloatingActionButton
    private lateinit var binding: ActivityGameBinding

    private val a = -150
    private val vp = 1f
    private val v0 = 400
    private val fps = 50
    private val sleepTime = 1000 / fps
    private var t = 0f
    var running = true
    var score = 0

//    private var mVelocityTracker: VelocityTracker? = null

    lateinit var mediaPlayer: MediaPlayer
    lateinit var character: Player
    lateinit var platform1: Platform
    lateinit var platform2: Platform
    lateinit var platform3: Platform
    lateinit var scoreText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        //begin music
        mediaPlayer = MediaPlayer.create(this, R.raw.mainloop)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        //character
        character = Player(binding.character)
        scoreText = binding.score

        //Platforms
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
            if (platform1.inVisible()) {
                platform1.updateTouch(vp)
            }
            character.jump(changeInHeight(t / 1000, (t - sleepTime) / 1000))
            t += sleepTime
            if (character.dead()) {
                running = false
                toMain()
            }
            if (character.collided(platform1)){
                t = 0f
                score += 1
            }
            Thread.sleep(sleepTime.toLong())
        }
    }

    private fun changeInHeight(t: Float, lastT: Float): Double {
        return v0 * t + 0.5 * a * t * t - (v0 * lastT + 0.5 * a * lastT * lastT)
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
        mediaPlayer.stop()
        finish()
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)

    }

}