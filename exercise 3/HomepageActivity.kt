package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomepageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        // Get the username passed from MainActivity
        val username = intent.getStringExtra("USERNAME_KEY")

        // Find the TextView where you want to display the username
        val usernameTextView = findViewById<TextView>(R.id.textView)

        // Set the text of the TextView dynamically to show the username
        usernameTextView.text = username ?: "No username found" // Fallback text if username is null
    }
}
