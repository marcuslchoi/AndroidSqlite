package com.example.androidsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSubmit = findViewById<Button>(R.id.myButton)
        //val txtView = findViewById<TextView>(R.id.myTextView)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextHobby = findViewById<EditText>(R.id.editTextHobby)

        btnSubmit.setOnClickListener {
            val rand = Random.nextInt(10)
            //txtView.text = "Random num: "+rand.toString()+" You said: "+editText.text
            //txtView.text += editText.text
        }
    }
}