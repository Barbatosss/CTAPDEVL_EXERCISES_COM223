package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {

    private lateinit var imageProfile: ImageView
    private lateinit var imageProfile2: ImageView

    private lateinit var postImage1: ImageView

    // Activity result launcher for picking an image
    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            imageProfile.setImageURI(it)
            imageProfile2.setImageURI(it)
        }
    }

    private val pickImageLauncherPost = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            postImage1.setImageURI(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val username = intent.getStringExtra("USERNAME_KEY")

        val usernameTextView = findViewById<TextView>(R.id.usernameTop)
        val usernameTextView2 = findViewById<TextView>(R.id.username)
        imageProfile = findViewById(R.id.imageProfile)
        imageProfile2 = findViewById(R.id.imageProfile2)
        postImage1 = findViewById(R.id.postImage1)

        usernameTextView.text = username ?: "No username found"
        usernameTextView2.text = username ?: "No username found"

        val editPictureButton = findViewById<Button>(R.id.editPictureButton)
        editPictureButton.setOnClickListener {
            // Launch image picker
            pickImageLauncher.launch("image/*")
        }

        val addPost = findViewById<ImageView>(R.id.addPost)
        addPost.setOnClickListener{
            // Launch image picker
            pickImageLauncherPost.launch("image/*")
        }
    }

}
