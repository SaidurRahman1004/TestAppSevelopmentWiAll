package com.example.testingpourposema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class lista : AppCompatActivity() {
    private lateinit var lvw:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        lvw = findViewById(R.id.lvw)
        val BestLang = resources.getStringArray(R.array.BestLang)
        var mlist = findViewById<ListView>(R.id.lvw)
        mlist.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,BestLang)


    }
}