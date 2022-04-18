package com.example.finalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.finalapp.databinding.ActivityScoresBinding
import com.example.finalapp.databinding.ActivitySettingsBinding

class ScoresActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScoresBinding
    lateinit var scoresBackButtton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)
        binding = ActivityScoresBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //back button
        scoresBackButtton = findViewById(R.id.scoresBackButton)
        scoresBackButtton.setOnClickListener {
            toMain()
        }

    }

    private fun toMain() {
        finish()
    }
}