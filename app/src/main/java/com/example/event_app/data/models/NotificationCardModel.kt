package com.example.event_app.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class NotificationCardModel(@DrawableRes val NotificationImage : Int,
                             @StringRes val NotificationTitle : Int,
                             @StringRes val NotificationDate : Int) {
}