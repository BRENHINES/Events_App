package com.example.event_app.presentation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.event_app.R
import com.example.event_app.databinding.ResetPasswordSubmitPageBinding
import com.example.event_app.databinding.SignUpPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class SignUpPage : AppCompatActivity() {

    private lateinit var binding: SignUpPageBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()

        binding = SignUpPageBinding.inflate(layoutInflater)

        // Binding vers la page précédente
        binding.leftArrow.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Binding vers la page de connexion
        binding.signUpBtn.setOnClickListener {
            // val intent = Intent(this, LoginPage::class.java)
            // val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out)
            // startActivity(intent, options.toBundle())
            val username = binding.userInputSignUp.text.toString()
            val email = binding.emailAddressInputSignUp.text.toString()
            val password = binding.passwordInputSignUp.text.toString()
            val confirmation_password = binding.passwordInputConfirmationSignUp.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmation_password.isNotEmpty()) {
                if (password == confirmation_password) {

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        //val userId = FirebaseAuth.getInstance().currentUser.uid

                        if (it.isSuccessful) {
                            val intent = Intent(this, LoginPage::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }

                        val userMap = hashMapOf(
                            "username" to username,
                            "email" to email,
                            "password" to password
                        )

                        // Enregistrement dans le firestore
                        db.collection("users").document().set(userMap)
                            .addOnSuccessListener {
                                Toast.makeText(this, "successfully added", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener{
                                Toast.makeText(this, "Failure added", Toast.LENGTH_SHORT).show()
                            }
                    }

                } else {
                    Toast.makeText(this, "Password is not matching.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty fields are not allowed.", Toast.LENGTH_SHORT).show()
            }
        }

        setContentView(binding.root)
    }
}