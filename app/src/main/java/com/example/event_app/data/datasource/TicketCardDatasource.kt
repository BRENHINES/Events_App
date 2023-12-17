package com.example.event_app.data.datasource

import com.example.event_app.R
import com.example.event_app.data.models.TicketCardModel

class TicketCardDatasource {

    fun loadCard() :MutableList<TicketCardModel> {
        return mutableListOf(
            TicketCardModel(
                R.drawable.background,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
            ),
            TicketCardModel(
                R.drawable.party,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
            ),
            TicketCardModel(
                R.drawable.party__2_,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
            ),
            TicketCardModel(
                R.drawable.confirmed_cuate,
                R.string.login,
                R.string.login,
                R.string.login,
                R.string.login,
            ),
        )
    }

}