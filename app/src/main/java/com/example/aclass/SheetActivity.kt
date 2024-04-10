package com.example.aclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SheetActivity : AppCompatActivity() {

    lateinit var btnSheet1: Button // Declare the Button variable as a member variable
    lateinit var btnSheet2: Button
    lateinit var btnSheet3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sheet_menu) // Use the correct layout file

        btnSheet1 = findViewById<Button>(R.id.btnSheet1) // Initialize the member variable
        btnSheet2 = findViewById<Button>(R.id.btnSheet2)
        btnSheet3 = findViewById<Button>(R.id.btnSheet3)


        // Set a click listener for the button
        btnSheet1.setOnClickListener {
            val intent = Intent(this@SheetActivity, ReadActivity::class.java)
            startActivity(intent)
        }
        btnSheet2.setOnClickListener {
            val intent = Intent(this@SheetActivity, ReadActivity2::class.java)
            startActivity(intent)
        }
        btnSheet3.setOnClickListener {
            val intent = Intent(this@SheetActivity, ReadActivity3::class.java)
            startActivity(intent)
        }
    }
}
