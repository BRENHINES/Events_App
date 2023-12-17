package com.example.event_app.domain.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R

class NotificationCardViewHolder(private var view : View) : RecyclerView.ViewHolder(view) {
    val NotificationImage = view.findViewById<ImageView>(R.id.notification_image)
    val NotificationTitle = view.findViewById<TextView>(R.id.notification_title)
    val NotificationTime = view.findViewById<TextView>(R.id.notification_time)
}