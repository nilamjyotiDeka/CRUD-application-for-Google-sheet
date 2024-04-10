package com.example.aclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.time.Instant

class MainActivity : AppCompatActivity() {

    lateinit var btnRead:Button
    lateinit var btnWrite:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRead=findViewById(R.id.btnRead)
        btnWrite=findViewById(R.id.btnWrite)

        btnRead.setOnClickListener {
            var intent= Intent(this@MainActivity,SheetActivity::class.java)
            startActivity(intent)
        }
        btnWrite.setOnClickListener {
            var intent= Intent(this@MainActivity,WriteSheetDispay::class.java)
            startActivity(intent)
        }

    }
}