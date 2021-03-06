package com.example.androidsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random
import android.content.Context
import android.util.Log
import android.widget.TextView

//create table and insert: https://www.youtube.com/watch?v=OxHNcCXnxnE
//read, delete: https://www.youtube.com/watch?v=vov_rsFWkmM
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("hi","on create main activity");
        val btnSubmit = findViewById<Button>(R.id.myButton)
        val btnRead = findViewById<Button>(R.id.readButton)
        //val txtView = findViewById<TextView>(R.id.myTextView)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextHobby = findViewById<EditText>(R.id.editTextHobby)
        val textViewData = findViewById<TextView>(R.id.textViewData)

        val context = this
        var db = DataBaseHandler(context)
        btnSubmit.setOnClickListener {
            //val rand = Random.nextInt(10)
            //txtView.text = "Random num: "+rand.toString()+" You said: "+editText.text
            //txtView.text += editText.text

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
        }


        btnRead.setOnClickListener {
            var dataList = db.readData()
            textViewData.text = ""
            for(i in 0..(dataList.size-1)) {
                var user = dataList.get(i);
                textViewData.append(user.name + " " +user.hobby+"\n")
            }
        }
    }
}