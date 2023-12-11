package com.example.event_app.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.event_app.R
import com.example.event_app.databinding.ResetPasswordPageBinding
import com.example.event_app.databinding.ResetPasswordSubmitPageBinding

class ResetPasswordPage : AppCompatActivity() {

    private lateinit var binding: ResetPasswordPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ResetPasswordPageBinding.inflate(layoutInflater)

        // Binding vers la de connexion
        binding.resetPasswordBtn.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        setContentView(binding.root)
    }
}