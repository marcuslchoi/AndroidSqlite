package com.example.androidsqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Users"
val COL_NAME = "name"
val COL_HOBBY = "hobby"
val COL_ID = "id"

//database helper method
class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,1)
{
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_HOBBY +" VARCHAR(256))";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user: User)
    {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_HOBBY, user.hobby)

        var rowId = db.insert(TABLE_NAME, null, cv)
        if(rowId == -1.toLong()) {
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
        }
    }

    fun readData(): MutableList<User>
    {
        var list: MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from "+ TABLE_NAME
        //read all data from db
        val result = db.rawQuery(query,null)
        //if cursor is not null and has at least 1 value
        if(result.moveToFirst())
        {
            do {
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.hobby = result.getString(result.getColumnIndex(COL_HOBBY))
                list.add(user)
            } while (result.moveToNext())
        }
        return list
    }
}