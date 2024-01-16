package com.example.event_app.presentation

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.event_app.R
import com.example.event_app.databinding.ResetPasswordSubmitPageBinding
import com.example.event_app.databinding.SignUpPageBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.firestore

class SignUpPage : AppCompatActivity() {

    private lateinit var binding: SignUpPageBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient : GoogleSignInClient
    private var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

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

                            val userID = FirebaseAuth.getInstance().currentUser!!.uid

                            val userMap = hashMapOf(
                                "userID" to userID,
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
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                } else {
                    Toast.makeText(this, "Password is not matching.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty fields are not allowed.", Toast.LENGTH_SHORT).show()
            }
        }

        // binding vers la création de compte avec Google
        binding.googleContinueBtn.setOnClickListener {
            googleSignUp();
        }

        // binding vers la création de compte en tant qu'invité
        binding.anonymousContinueBtn.setOnClickListener {
            firebaseAuth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, HomePage::class.java)
                        startActivity(intent)
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
                        val user = firebaseAuth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "not connected", Toast.LENGTH_SHORT).show()
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }
        }

        setContentView(binding.root)
    }

    private fun googleSignUp() {

        val signInClient = googleSignInClient.signInIntent
        launcher.launch(signInClient)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)

            manageResults(task);
        }
    }

    private fun manageResults(task: Task<GoogleSignInAccount>) {

        val account : GoogleSignInAccount? = task.result

        if (account != null) {
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, HomePage::class.java)
                    startActivity(intent)

                    Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }

    }
}