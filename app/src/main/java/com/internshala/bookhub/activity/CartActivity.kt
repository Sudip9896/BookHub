package com.internshala.bookhub.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.internshala.bookhub.R

import java.text.SimpleDateFormat
import java.util.*

class CartActivity : AppCompatActivity() {

    lateinit var txtcartbookname: TextView
    lateinit var txtcartbookprice: TextView
    lateinit var btnProceed: Button
    lateinit var bookName : String
    lateinit var address : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        txtcartbookname = findViewById(R.id.BookName)
        txtcartbookprice = findViewById(R.id.price)
        btnProceed = findViewById(R.id.btnProceed)
        address = findViewById(R.id.etxtaddress)


        bookName = intent.getStringExtra("book_name") ?: "Default Book Name"
        val bookPrice = intent.getStringExtra("book_price") ?: "Rs. 0"


        txtcartbookname.text = "$bookName"
        txtcartbookprice.text = "$bookPrice"


        btnProceed.setOnClickListener {

            val enteredAddress = address.text.toString().trim()

            if (enteredAddress.length > 150) {
                address.error = "Maximum 150 characters allowed"
            } else if (enteredAddress.isEmpty()) {
                address.error = "Please enter your address"
                // Set the "Proceed" button color to red
                btnProceed.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))
            } else if (enteredAddress.length >= 10) {
                // Proceed to the next activity
                val intent = Intent(this@CartActivity, orderplaced::class.java)
                startActivity(intent)
                // Set the "Proceed" button color to green
                btnProceed.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
            } else {
                address.error = "Address should be at least 25 characters"
            }
        }
    }
}
