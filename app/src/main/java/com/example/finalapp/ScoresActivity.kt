package com.example.finalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapp.databinding.ActivityScoresBinding
import com.example.finalapp.databinding.ActivitySettingsBinding

class ScoresActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScoresBinding
    lateinit var scoresBackButtton: Button
    lateinit var scoresList: RecyclerView
    private var lastScore: String? = null

    private val newScoreActivityRequestCode = 1
    private val scoreViewModel: ScoreViewModel by viewModels{
        ScoreViewModelFactory((application as ScoresApplication).repository)
    }

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
        val score = Score(lastScore!!)
        if (lastScore != "null") {
            scoreViewModel.insert(score)
        }
        val recyclerView = findViewById<RecyclerView>(R.id.scoresView)
        val adapter = ScoreListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        scoreViewModel.allScores.observe(this) { scores ->
            scores.let {adapter.submitList(it)}
        }

        scoresBackButtton.setOnClickListener {
            toMain()
        }

    }

//    override fun onActivityResult()

    private fun toMain() {
        finish()
    }
}