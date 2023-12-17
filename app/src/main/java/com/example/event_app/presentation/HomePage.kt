package com.example.event_app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.event_app.R
import com.example.event_app.databinding.HomePageBinding
import com.example.event_app.presentation.fragments.AddFragment
import com.example.event_app.presentation.fragments.HomeFragment
import com.example.event_app.presentation.fragments.NotificationsFragment
import com.example.event_app.presentation.fragments.ProfileFragment
import com.example.event_app.presentation.fragments.TicketFragment

class HomePage : AppCompatActivity() {

    private lateinit var binding : HomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Making binding in the Home Page
        binding = HomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set a default page to show when we open the app
        replaceFragment(HomeFragment())

        // Set the button click to change fragments page
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.navHome -> replaceFragment(HomeFragment())
                R.id.navTicket -> replaceFragment(TicketFragment())
                R.id.navAdd -> replaceFragment(AddFragment())
                R.id.navProfile -> replaceFragment(ProfileFragment())

                else -> {  }
            }
            true
        }
    }

    /* replaceFragment function to replace
    fragment when we click on the icon
    button on the bottom nav bar */
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}