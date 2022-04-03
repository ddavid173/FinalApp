package com.example.finalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var backButton: Button
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        backButton = findViewById(R.id.button)

        backButton.setOnClickListener {
            toMain()
        }

    }

    private fun toMain() {
        val intent = Intent(this,MainActivity::class.java).apply {}
        startActivity(intent)
    }
}