package com.example.event_app.data.datasource

import com.example.event_app.R
import com.example.event_app.data.models.EventCardModel

class EventCardDataSource {
    fun loadCard() :MutableList<EventCardModel> {
        return mutableListOf(
            EventCardModel(
                R.drawable.conference,
                R.string.popularTitle1,
                R.string.popularDay1,
                R.string.popularMonth1,
                R.string.popularCategory1,
                R.string.login,
                R.string.EventPrice1,
                R.string.EventSpace1
            ),
            EventCardModel(
                R.drawable.party,
                R.string.popularTitle2,
                R.string.popularDay2,
                R.string.popularMonth2,
                R.string.popularCategory2,
                R.string.login,
                R.string.EventPrice2,
                R.string.EventSpace3
            ),
            EventCardModel(
                R.drawable.party__2_,
                R.string.popularTitle3,
                R.string.popularDay3,
                R.string.popularMonth3,
                R.string.popularCategory3,
                R.string.login,
                R.string.EventPrice3,
                R.string.EventSpace3
            ),
            EventCardModel(
                R.drawable.concert_fally,
                R.string.popularTitle4,
                R.string.popularDay4,
                R.string.popularMonth4,
                R.string.popularCategory4,
                R.string.login,
                R.string.EventPrice4,
                R.string.EventSpace4
            ),
        )
    }
}