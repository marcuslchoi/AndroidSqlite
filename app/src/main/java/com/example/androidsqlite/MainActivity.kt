package com.example.androidsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random
import android.content.Context
import android.util.Log

//create table and insert: https://www.youtube.com/watch?v=OxHNcCXnxnE
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("hi","on create main activity");
        val btnSubmit = findViewById<Button>(R.id.myButton)
        //val txtView = findViewById<TextView>(R.id.myTextView)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextHobby = findViewById<EditText>(R.id.editTextHobby)

        val context = this
        btnSubmit.setOnClickListener {
            //val rand = Random.nextInt(10)
            //txtView.text = "Random num: "+rand.toString()+" You said: "+editText.text
            //txtView.text += editText.text
            var db = DataBaseHandler(context)
            if(editTextName.text.toString().length > 0 &&
                    editTextHobby.text.toString().length > 0)
            {
                var user = User(editTextName.text.toString(), editTextHobby.text.toString())

                db.insertData(user)
                Log.d("hi","user inserted");
            }
            else
            {
                Log.d("hi","all fields not filled");
                Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT)
            }
            db.readData()
        }
    }
}