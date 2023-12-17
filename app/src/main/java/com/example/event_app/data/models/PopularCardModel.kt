package com.example.events.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class PopularCardModel(@DrawableRes val popularEventImage : Int,
                       @StringRes val popularEventTitle : Int,
                       @StringRes val popularEventDay : Int,
                       @StringRes val popularEventMonth : Int,
                       @StringRes val popularEventCategory : Int) {
}