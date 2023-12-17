package com.example.events.data.data

import com.example.event_app.R
import com.example.events.data.models.PopularCardModel

class PopularCardDataSource {
    fun loadCard() :MutableList<PopularCardModel> {
        return mutableListOf(
            PopularCardModel(
                R.drawable.conference,
                R.string.popularTitle1,
                R.string.popularDay1,
                R.string.popularMonth1,
                R.string.popularCategory1,
            ),
            PopularCardModel(
                R.drawable.party,
                R.string.popularTitle2,
                R.string.popularDay2,
                R.string.popularMonth2,
                R.string.popularCategory2,
            ),
            PopularCardModel(
                R.drawable.party__2_,
                R.string.popularTitle3,
                R.string.popularDay3,
                R.string.popularMonth3,
                R.string.popularCategory3,
            ),
            PopularCardModel(
                R.drawable.concert_fally,
                R.string.popularTitle4,
                R.string.popularDay4,
                R.string.popularMonth4,
                R.string.popularCategory4,
            ),
        )
    }
}