package com.example.finalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.finalapp.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    lateinit var settingsBackButton: Button

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
    }

    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java).apply {}
        startActivity(intent)
    }


}