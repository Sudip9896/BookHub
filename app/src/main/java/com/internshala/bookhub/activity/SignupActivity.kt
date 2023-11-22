package com.internshala.bookhub.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.internshala.bookhub.R
import com.internshala.bookhub.databinding.ActivitySignupBinding
import com.internshala.bookhub.fragment.AboutAppFragment


class SignupActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivitySignupBinding
    private lateinit var  databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)
        binding.btnSignup.setOnClickListener {

            val signupUsername = binding.EtxtUserName.text.toString()
            val signupPassword = binding.EtxtUserPassword.text.toString()
            val mobilenumber = binding.Etxtmobilenumber.text.toString()
            val Email = binding.EtxtEmail.text.toString()
           /* val fragment = AboutAppFragment()
            val bundle = Bundle()
            bundle.putString("username", signupUsername)
            bundle.putString("mobile", mobilenumber)
            bundle.putString("Email",Email)
            fragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentcontiner, fragment)
                .commit()*/

            signupDatabase(signupUsername,signupPassword,Email,mobilenumber)

        }
        binding.txtAlreadyRegisterLogin.setOnClickListener {

            val intent = Intent(this ,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun signupDatabase(username: String, password: String, email: String, mobile: String) {
        val insertRowId = databaseHelper.insertUser(username, password, email, mobile)
        if (insertRowId != -1L) {
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Signup failed", Toast.LENGTH_SHORT).show()
        }
    }
}