package com.example.event_app.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.event_app.R
import com.example.event_app.databinding.ForgotPasswordPageBinding
import com.example.event_app.databinding.ResetPasswordSubmitPageBinding

class ResetPasswordSubmitPage : AppCompatActivity() {

    private lateinit var binding: ResetPasswordSubmitPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ResetPasswordSubmitPageBinding.inflate(layoutInflater)

        // Binding vers la page précédente
        binding.leftArrow.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Binding vers la page de reinitialisation du mot de passe
        binding.resetPassword.setOnClickListener {
            val intent = Intent(this, ResetPasswordPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        setContentView(binding.root)
    }
}