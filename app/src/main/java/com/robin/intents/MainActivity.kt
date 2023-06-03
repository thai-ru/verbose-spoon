package com.robin.intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val FULL_NAME_KEY = "FULL_NAME_KEY"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.submit_button).setOnClickListener {

            val fullName = findViewById<EditText>(R.id.full_name).text.toString().trim()

            if (fullName.isNotEmpty()){
                //Launch the main activity
                Intent(this, WelcomeActivity::class.java).also {welcomeIntent ->
                    welcomeIntent.putExtra(FULL_NAME_KEY, fullName)
                    //launch the WelcomeActivity
                    startActivity(welcomeIntent)
                }
            }else {
                //Show an error message
                Toast.makeText(this, getString(R.string.full_name_label), Toast.LENGTH_SHORT).show()
            }
        }
    }
}