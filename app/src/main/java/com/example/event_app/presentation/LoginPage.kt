package com.example.event_app.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.addCallback
import com.example.event_app.R
import com.example.event_app.databinding.LoginPageBinding

class LoginPage : AppCompatActivity() {

    private lateinit var binding: LoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginPageBinding.inflate(layoutInflater)

        // Binding pour la page Home
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, SignUpPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        // Binding pour aller a la page de sign up
        binding.signUp.setOnClickListener {
            val intent = Intent(this, SignUpPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        // Binding pour aller a la page forgot password
        binding.forgetPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        setContentView(binding.root)
    }
}