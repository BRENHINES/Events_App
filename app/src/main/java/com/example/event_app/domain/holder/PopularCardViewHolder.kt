package com.example.events.domain.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R

class PopularCardViewHolder (private var view : View) : RecyclerView.ViewHolder(view) {
    val popularEventImage = view.findViewById<ImageView>(R.id.PopularCardImage)
    val popularEventTitle = view.findViewById<TextView>(R.id.PopularCardTitle)
    val popularEventDay = view.findViewById<TextView>(R.id.PopularCardDay)
    val popularEventMonth = view.findViewById<TextView>(R.id.PopularCardMonth)
    val popularEventCategory = view.findViewById<TextView>(R.id.PopularCardCategory)
}