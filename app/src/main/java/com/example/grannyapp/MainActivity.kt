package com.example.grannyapp

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

public var users = ArrayList<MainActivity.User>()

var arrUser = arrayOf("fruityloopes", "chadandrews", "st10085138")
var arrPassword = arrayOf("password01", "computerlab", "ps5ps4ps3")


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users.add(User(arrUser[0], arrPassword[0], "user1"))
        users.add(User(arrUser[1], arrPassword[1], "user2"))
        users.add(User(arrUser[2], arrPassword[2], "user3"))

        val login : Button = findViewById(R.id.btnLogin)
        val reg : Button = findViewById(R.id.btnReg)
        val username : TextView = findViewById(R.id.txtUsername)
        val password : TextView = findViewById(R.id.txtPassword)
        val intent = Intent(applicationContext, HomePage::class.java)
        val intentReg = Intent(applicationContext, RegisterPage::class.java)




        login.setOnClickListener()
        {
            val name = username.text.toString().trim()
            val pass = password.text.toString().trim()
            var check = 0
            if(name.isEmpty())
            {
                username.error = "Enter username"
                username.requestFocus()
            } else if(pass.isEmpty())
            {
                password.error = "Enter password"
                password.requestFocus()
            } else
            {
                    for (i in users.indices)
                    {

                        if(name == users[i].username && pass == users[i].password)
                        {
                            check++
                            intent.putExtra("message_key" , users[i].img)
                            startActivity(intent)
                            finish()
                            break
                        }

                    }
                    if (check == 0)
                    {
                        Toast.makeText(this , "Incorrect username or password" , Toast.LENGTH_SHORT).show()
                    }

            }

        }

        reg.setOnClickListener()
        {

            startActivity(intentReg)
            finish()
        }
    }

    data class User
        (
            val username : String,
            val password : String,
            val img : String

        )





}