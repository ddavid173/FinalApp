package com.example.finalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapp.databinding.ActivityScoresBinding
import com.example.finalapp.databinding.ActivitySettingsBinding

class ScoresActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScoresBinding
    lateinit var scoresBackButtton: Button
    lateinit var scoresList: RecyclerView
    private var lastScore: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)
        binding = ActivityScoresBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //back button
        scoresBackButtton = binding.scoresBackButton
        scoresList = binding.scoresView
        lastScore = intent.getStringExtra("score").toString()

        //TODO: add the latest score to the RecyclerView

        scoresBackButtton.setOnClickListener {
            toMain()
        }

    }

    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }
}