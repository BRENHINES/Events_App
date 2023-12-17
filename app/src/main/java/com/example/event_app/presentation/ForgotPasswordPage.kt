package com.example.event_app.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.event_app.R
import com.example.event_app.databinding.ForgotPasswordPageBinding
import com.example.event_app.databinding.LoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordPage : AppCompatActivity() {

    private lateinit var binding : ForgotPasswordPageBinding
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ForgotPasswordPageBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()

        val email = binding.emailAddressInputPasswordForgot

        // Binding vers la page précédente
        binding.leftArrow.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Binding vers la page de confirmation de soumission de reset password
        binding.submitBtn.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            startActivity(intent, options.toBundle())

            compareEmail(email)

        }

        setContentView(binding.root)
    }

    private fun compareEmail(email: EditText) {
        if (email.text.toString().isEmpty()) {
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            return
        }
        firebaseAuth.sendPasswordResetEmail(email.text.toString()).addOnCompleteListener {
            task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Check your email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}