package com.example.event_app.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class TicketCardModel(@DrawableRes val TicketEventImage : Int,
                      @StringRes val TicketEventTitle : Int,
                      @StringRes val TicketEventDay : Int,
                      @StringRes val TicketEventMonth : Int,
                      @StringRes val TicketEventCategory : Int) {
}