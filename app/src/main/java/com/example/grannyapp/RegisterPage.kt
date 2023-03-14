package com.example.grannyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)


        val reg : Button = findViewById(R.id.btnReg)
        val intent = Intent(applicationContext, MainActivity::class.java)
        val username : TextView = findViewById(R.id.txtUsername)
        val password : TextView = findViewById(R.id.txtPassword)

        reg.setOnClickListener()
        {
            val name = username.text.toString().trim()
            val pass = password.text.toString().trim()

            if(name.isEmpty())
            {
                username.error = "Enter username"
                username.requestFocus()
            } else if(pass.isEmpty())
            {
                password.error = "Enter password"
                password.requestFocus()
            } else {
                users.add(MainActivity.User(username.text.toString(), password.text.toString(), ""))

                Toast.makeText(this, "You have been registered", Toast.LENGTH_SHORT).show()

                startActivity(intent)
                finish()
            }

        }
    }
}