package com.example.event_app.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.event_app.R
import com.example.event_app.databinding.LoginChoicePageBinding
import com.example.event_app.databinding.LoginPageBinding

class LoginChoicePage : AppCompatActivity() {

    private lateinit var binding: LoginChoicePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = LoginChoicePageBinding.inflate(layoutInflater)

        // Binding vers le login page
        binding.SignInWithPassword.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        // Binding vers le sign up page
        binding.signUp.setOnClickListener {
            val intent = Intent(this, SignUpPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        setContentView(binding.root)
    }
}