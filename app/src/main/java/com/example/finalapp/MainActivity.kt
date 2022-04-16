package com.example.finalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.finalapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var startButton: Button
    lateinit var settingsButton: Button
    lateinit var scoresButton: Button
    lateinit var aboutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //start button
        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            start()
        }

        //settings button
        settingsButton = findViewById(R.id.settingsbutton)
        settingsButton.setOnClickListener {
            settings()
        }

        //scores button
        scoresButton = findViewById(R.id.scoresButton)
        scoresButton.setOnClickListener {
            scores()
        }

        //about button
        aboutButton = findViewById(R.id.aboutButton)
        aboutButton.setOnClickListener {
            about()
        }


    }

    private fun start(){
        val intent = Intent(this, GameActivity::class.java).apply {}
        startActivity(intent)
    }

    private fun settings() {
        val intent = Intent( this, SettingsActivity::class.java).apply {}
        startActivity(intent)
    }

    private fun scores() {
        val intent = Intent( this, ScoresActivity::class.java).apply {}
        startActivity(intent)
    }

    private fun about() {
        val intent = Intent( this, about::class.java).apply {}
        startActivity(intent)
    }
}