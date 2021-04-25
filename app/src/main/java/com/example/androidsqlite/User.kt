package com.example.androidsqlite

class User {
    var id: Int = 0
    var name: String = ""
    var hobby: String = ""

    constructor(name:String, hobby:String)
    {
        this.name = name
        this.hobby = hobby
    }

}