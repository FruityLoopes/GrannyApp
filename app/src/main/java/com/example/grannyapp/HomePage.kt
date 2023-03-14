package com.example.grannyapp

import android.content.Intent
import android.graphics.drawable.TransitionDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toDrawable

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val image : ImageView = findViewById(R.id.imgUser)
        val logout : Button = findViewById(R.id.btnLogout)

        val strImg = intent.getStringExtra("message_key")


        if (strImg =="user1")
        {
           val drawable = resources.getDrawable(R.drawable.user1)
            image.setImageDrawable(drawable)
        } else  if (strImg =="user2")
        {
            val drawable = resources.getDrawable(R.drawable.user2)
            image.setImageDrawable(drawable)
        } else if (strImg =="user3")
        {
            val drawable = resources.getDrawable(R.drawable.user3)
            image.setImageDrawable(drawable)
        }

        val intent = Intent(applicationContext, MainActivity::class.java)

        logout.setOnClickListener(){
            startActivity(intent)
            finish()
        }
    }
}