package com.example.event_app.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.event_app.R
import com.example.event_app.databinding.ForgotPasswordPageBinding
import com.example.event_app.databinding.LoginPageBinding

class ForgotPasswordPage : AppCompatActivity() {

    private lateinit var binding: ForgotPasswordPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ForgotPasswordPageBinding.inflate(layoutInflater)

        // Binding vers la page précédente
        binding.leftArrow.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Binding vers la page de confirmation de soumission de reset password
        binding.submitBtn.setOnClickListener {
            val intent = Intent(this, ResetPasswordSubmitPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        setContentView(binding.root)
    }
}