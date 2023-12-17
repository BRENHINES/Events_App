package com.example.event_app.data.datasource

import com.example.event_app.R
import com.example.event_app.data.models.NotificationCardModel

class NotificationCardDataSource {
    fun loadCard() : MutableList<NotificationCardModel> {
        return mutableListOf(
            NotificationCardModel(
                R.drawable.background,
                R.string.onboarding_1_title,
                R.string.date
            ),
            NotificationCardModel(
                R.drawable.background,
                R.string.onboarding_1_title,
                R.string.date
            ),
        )
    }
}