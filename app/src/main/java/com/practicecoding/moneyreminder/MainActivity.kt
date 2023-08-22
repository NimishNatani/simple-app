package com.practicecoding.moneyreminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.practicecoding.moneyreminder.activity.insertname

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button = findViewById(R.id.button)
        btn.setOnClickListener(){
            val intent = Intent(this@MainActivity,insertname::class.java)
            startActivity(intent)
        }
    }
}