package com.internshala.bookhub.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.internshala.bookhub.R
import com.internshala.bookhub.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityLoginBinding
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        databaseHelper = DatabaseHelper(this)
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        if (isLoggedIn()) {
            startMainActivity()
        }

        binding.btnLogin.setOnClickListener {

            val loginUsername = binding.EtxtUserName.text.toString()
            val loginPassword = binding.EtxtUserPassword.text.toString()
            loginDatabase(loginUsername,loginPassword)

        }
        binding.txtNotRegisterLogin.setOnClickListener {

            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
    private fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("IS_LOGGED_IN", false)
    }
    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
  public fun setLoggedIn(isLoggedIn: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("IS_LOGGED_IN", isLoggedIn)
        editor.apply()
    }

    private fun loginDatabase(username: String,password: String)
    {
        val userExists = databaseHelper.readUser(username,password)

        if (userExists)
        {
            Toast.makeText(this, "login SuccessFull", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            setLoggedIn(true)
            finish()

        }
        else
        {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }


}
