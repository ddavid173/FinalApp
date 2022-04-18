package com.example.finalapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.finalapp.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    lateinit var settingsBackButton: Button
    lateinit var resetScoreButton: Button
    lateinit var musicToggleButton: Button
    lateinit var mediaPlayer: MediaPlayer

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
    }

    private fun toMain() {
        finish()
    }

    private fun resetScores(){
        // will erase the list of scores saved on app
    }

    private fun musicToggle(){
        //will toggle music on or off TODO:FIX
        if (mediaPlayer.isPlaying){
            mediaPlayer.stop()
            Toast.makeText(applicationContext, "Music turned off", Toast.LENGTH_LONG).show()
        }
        else {
            mediaPlayer.start()
            Toast.makeText(applicationContext, "Music turned on", Toast.LENGTH_LONG).show()

        }

    }



}