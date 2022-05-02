package com.example.finalapp

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.example.finalapp.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    lateinit var settingsBackButton: Button
    lateinit var resetScoreButton: Button
    lateinit var musicToggleButton: Button
    lateinit var hardModeButton: Button
    private val scoreViewModel: ScoreViewModel by viewModels{
        ScoreViewModelFactory((application as ScoresApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //back button
        settingsBackButton = findViewById(R.id.settingsBackButton)
        settingsBackButton.setOnClickListener {
            toMain()
        }

        //reset score button
        resetScoreButton = findViewById(R.id.resetScoreButton)
        resetScoreButton.setOnClickListener {
            resetScores()
        }

        //music toggle button
        musicToggleButton = findViewById(R.id.toggleMusic)
        musicToggleButton.setOnClickListener {
            musicToggle()
        }
        // Hard Mode
        hardModeButton = findViewById(R.id.hardMode)
        hardModeButton.setOnClickListener {
            hardToggle()
        }

    }

    private fun toMain() {
        finish()
    }

    private fun resetScores(){
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.05f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.05f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(resetScoreButton, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()

        scoreViewModel.delete()
        Toast.makeText(applicationContext, "Scores have been reset", Toast.LENGTH_SHORT).show()
        // will erase the list of scores saved on app
    }

    private fun hardToggle(){
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.05f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.05f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(hardModeButton, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()

        if (GameActivity.Toggle.bool){
            GameActivity.Toggle.bool = false
            Toast.makeText(applicationContext, "Hard Mode turned off, start game to apply changes", Toast.LENGTH_SHORT).show()
        }
        else {
            GameActivity.Toggle.bool = true
            Toast.makeText(applicationContext, "Hard Mode turned on, start game to apply changes", Toast.LENGTH_SHORT).show()

        }
    }

    private fun musicToggle(){
        //will toggle music on or off
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.05f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.05f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(musicToggleButton, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()

        if (MainActivity.Toggle.bool){
            MainActivity.Toggle.bool = false
            Toast.makeText(applicationContext, "Music turned off, start game to apply changes", Toast.LENGTH_SHORT).show()
        }
        else {
            MainActivity.Toggle.bool = true
            Toast.makeText(applicationContext, "Music turned on, start game to apply changes", Toast.LENGTH_SHORT).show()

        }

    }



}