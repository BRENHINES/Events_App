package com.example.event_app.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class EventCardModel(@DrawableRes val EventImage : Int,
                     @StringRes val EventTitle : Int,
                     @StringRes val EventDay : Int,
                     @StringRes val EventMonth : Int,
                     @StringRes val EventCategory : Int,
                     @StringRes val EventTime : Int,
                     @StringRes val EventPrice : Int,
                     @StringRes val EventSpace : Int) {
}