package com.example.events.data.data

import com.example.event_app.R
import com.example.events.data.models.PopularCardModel

class PopularCardDataSource {
    fun loadCard() :MutableList<PopularCardModel> {
        return mutableListOf(
            PopularCardModel(
                R.drawable.background,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
            ),
            PopularCardModel(
                R.drawable.background,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
            ),
            PopularCardModel(
                R.drawable.background,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
            ),
            PopularCardModel(
                R.drawable.background,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
            ),
        )
    }
}