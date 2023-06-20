package com.example.billz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        usernameEditText = findViewById(R.id.usernameEditText)
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        registerButton = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        var username = usernameEditText.text.toString().trim()
        var phoneNumber = phoneNumberEditText.text.toString().trim()
        var email = emailEditText.text.toString().trim()
        var password = passwordEditText.text.toString().trim()

        if (username.isEmpty()) {
            usernameEditText.error = "Username is required"
            usernameEditText.requestFocus()
            return
        }

        if (phoneNumber.isEmpty()) {
            phoneNumberEditText.error = "Phone number is required"
            phoneNumberEditText.requestFocus()
            return
        }

        if (email.isEmpty()) {
            emailEditText.error = "Email is required"
            emailEditText.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Enter a  email address"
            emailEditText.requestFocus()
            return
        }

        if (password.isEmpty()) {
            passwordEditText.error = "Password is required"
            passwordEditText.requestFocus()
            return
        }


        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
    }
}