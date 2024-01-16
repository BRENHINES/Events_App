package com.example.event_app.presentation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.event_app.R
import com.example.event_app.databinding.HomeFragmentBinding
import com.example.event_app.databinding.ProfileFragmentBinding
import com.example.event_app.presentation.LoginChoicePage
import com.example.event_app.presentation.LoginPage
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : com.example.event_app.databinding.ProfileFragmentBinding
    lateinit var auth : FirebaseAuth
    private var db = Firebase.firestore
    private lateinit var name : TextView
    private lateinit var email : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ProfileFragmentBinding.inflate(layoutInflater)
        auth = Firebase.auth

        val name = binding.username
        val email = binding.email

        val userID = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = db.collection("users").document(userID)

        ref.get().addOnSuccessListener {
            if (it != null) {
                val username = it.data?.get("username")?.toString()
                val useremail = it.data?.get("email")?.toString()

                name.text = username
                email.text = useremail
            }
        }

        val user = auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val name = it.displayName
            val email = it.email
            val photoUrl = it.photoUrl
            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            val uid = it.uid

            print(name)
        }

        val collectionRef = db.collection("users")
        val query = collectionRef.whereEqualTo("userID", "currentUserID")

        query.get().addOnSuccessListener {
                documents -> for (document in documents) {
            val name = document.getString("username")

            binding.username.text = name
        }
        }

        ref.get().addOnSuccessListener {
            if (it != null) {
                val username = it.data?.get("email")?.toString()

                // binding.username.text = username

                val user = auth.currentUser
                user?.let {
                    // Name, email address, and profile photo Url
                    val name = it.displayName
                    val email = it.email
                    val photoUrl = it.photoUrl
                    // The user's ID, unique to the Firebase project. Do NOT use this value to
                    // authenticate with your backend server, if you have one. Use
                    // FirebaseUser.getIdToken() instead.
                    val uid = it.uid

                    binding.email.text = email
                }

            }
        }

        binding.logout.setOnClickListener {
            auth.signOut();

            val intent = Intent(requireContext(), LoginChoicePage::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}