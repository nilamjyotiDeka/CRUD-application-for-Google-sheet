package com.example.aclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class  WriteSheetDispay : AppCompatActivity() {

    lateinit var btnWriteSheet1: Button
    lateinit var btnWriteSheet2: Button
    lateinit var btnWriteSheet3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.write_sheetmenu)

        btnWriteSheet1 = findViewById<Button>(R.id.btnWriteSheet1)
        btnWriteSheet2 = findViewById<Button>(R.id.btnWriteSheet2)
        btnWriteSheet3 = findViewById<Button>(R.id.btnWriteSheet3)

        // Set click listeners for the buttons
        btnWriteSheet1.setOnClickListener {
            val intent = Intent(this@WriteSheetDispay, WriteActivity::class.java)
            startActivity(intent)
        }

        btnWriteSheet2.setOnClickListener {
            val intent = Intent(this@WriteSheetDispay, WriteActivity::class.java)
            startActivity(intent)
        }

        btnWriteSheet3.setOnClickListener {
            val intent = Intent(this@WriteSheetDispay, WriteActivity::class.java)
            startActivity(intent)
        }
    }
}
