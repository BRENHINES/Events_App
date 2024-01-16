package com.example.event_app.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.event_app.R
import com.example.event_app.data.datasource.EventCardDataSource
import com.example.event_app.databinding.HomeFragmentBinding
import com.example.event_app.presentation.adapter.EventCardAdapter
import com.example.events.data.data.PopularCardDataSource
import com.example.events.data.data.TagDatasource
import com.example.events.presentation.adapter.PopularCardAdapter
import com.example.events.presentation.adapter.TagAdapter
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.firestore

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : HomeFragmentBinding
    private var db = Firebase.firestore
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var username_bind : TextView

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

        binding = HomeFragmentBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()

        // Popular RecyclerView
        val PopularDataSource = PopularCardDataSource().loadCard()
        val PopularAdapter = PopularCardAdapter(this, PopularDataSource)

        binding.popularRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecyclerView.adapter = PopularAdapter


        username_bind = binding.username

        // Event RecyclerView
        val EventDataSource = EventCardDataSource().loadCard()
        val EventAdapter = EventCardAdapter(this, EventDataSource)

        binding.forYouRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.forYouRecyclerView.adapter = EventAdapter

        val currentUserID = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = db.collection("users").document(currentUserID)

        val collectionRef = db.collection("users")
        val query = collectionRef.whereEqualTo("userID", "currentUserID")

        query.get().addOnSuccessListener {
            documents -> for (document in documents) {
                val username = document.getString("username")

                binding.username.text = username
            }
        }

        ref.get().addOnSuccessListener {
            if (it != null) {
                val username = it.data?.get("email")?.toString()

                // binding.username.text = username

                val user = firebaseAuth.currentUser
                user?.let {
                    // Name, email address, and profile photo Url
                    val name = it.displayName
                    val email = it.email
                    val photoUrl = it.photoUrl
                    // The user's ID, unique to the Firebase project. Do NOT use this value to
                    // authenticate with your backend server, if you have one. Use
                    // FirebaseUser.getIdToken() instead.
                    val uid = it.uid

                    // binding.username.text = email
                }

            }
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
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}