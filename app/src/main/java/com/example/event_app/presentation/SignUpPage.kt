package com.example.event_app.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.event_app.R
import com.example.event_app.databinding.ResetPasswordSubmitPageBinding
import com.example.event_app.databinding.SignUpPageBinding

class SignUpPage : AppCompatActivity() {

    private lateinit var binding: SignUpPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignUpPageBinding.inflate(layoutInflater)

        // Binding vers la page précédente
        binding.leftArrow.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Binding vers la page de connexion
        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        setContentView(binding.root)
    }
}