package com.example.finalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.finalapp.databinding.ActivityAboutBinding

class about : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    lateinit var aboutBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //back button
        aboutBackButton = findViewById(R.id.aboutBackButton)
        aboutBackButton.setOnClickListener {
            toMain()
        }

    }

    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }



}