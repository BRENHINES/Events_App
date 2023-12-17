package com.example.event_app.data.datasource

import com.example.event_app.R
import com.example.event_app.data.models.EventCardModel

class EventCardDataSource {
    fun loadCard() :MutableList<EventCardModel> {
        return mutableListOf(
            EventCardModel(
                R.drawable.background,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login
            ),
            EventCardModel(
                R.drawable.background,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login
            ),
            EventCardModel(
                R.drawable.background,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login
            ),
            EventCardModel(
                R.drawable.background,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login
            ),
        )
    }
}