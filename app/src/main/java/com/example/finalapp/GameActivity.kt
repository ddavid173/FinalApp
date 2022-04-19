package com.example.finalapp

import android.content.Intent
import android.content.res.Resources
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

    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels
    private val a = screenHeight / 5.5 * -1
    private val vp = screenHeight / 700
    private val v0 = screenHeight / 3
    private val fps = 50
    private val sleepTime = 1000 / fps
    private var t = 0f
    var running = true
    var score = 0

//    private var mVelocityTracker: VelocityTracker? = null

    lateinit var gamePlayer: MediaPlayer
    lateinit var character: Player
    lateinit var platform1: Platform
    lateinit var platform2: Platform
    lateinit var platform3: Platform
    lateinit var platform4: Platform
    lateinit var scoreText: TextView
    private var platforms = listOf<Platform>()

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
        if (MainActivity.Toggle.bool) {
            gamePlayer = MediaPlayer.create(this, R.raw.mainloop)
            gamePlayer.isLooping = true
            gamePlayer.start()
        }

        //character
        character = Player(binding.character)
        scoreText = binding.score

        //Platforms
        platform1 = Platform(binding.platform1)
        platform2 = Platform(binding.platform2)
        platform3 = Platform(binding.platform3)
        platform4 = Platform(binding.platform4)
        platform1.setUp(platform4, true)
        platform2.setUp(platform1, false)
        platform3.setUp(platform2, false)
        platform4.setUp(platform3, false)
        platforms = listOf<Platform>(platform1, platform2, platform3, platform4)

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
            character.jump(changeInHeight(t / 1000, (t - sleepTime) / 1000))
            for (plat in platforms) {
                plat.updateTouch(vp)
                if (character.collided(plat)) {
                    t = 0f
                    score += 1
                }
                if (plat.onBotton()){ plat.reset() }
            }
            if (character.dead()) {
                running = false
                toMain()
            }
            t += sleepTime
            println("score $score")
            Thread.sleep(sleepTime.toLong())
            //Thread.sleep(200)
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
        if (this::gamePlayer.isInitialized) {
            gamePlayer.stop()
        }
        finish()

        val intent = Intent(this, MainActivity::class.java).apply {}
        intent.putExtra("score", score.toString())
        startActivity(intent)

    }

}