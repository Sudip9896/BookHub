package com.internshala.bookhub.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.internshala.bookhub.R

class orderplaced : AppCompatActivity() {

    lateinit var confimbutton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderplaced)

        confimbutton = findViewById(R.id.bttn)

        confimbutton.setOnClickListener {

            val intent =
                Intent(this@orderplaced, MainActivity::class.java)
            startActivity(intent)
        }
    }
}