package com.example.event_app.domain.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R

class EventCardViewHolder  (private var view : View) : RecyclerView.ViewHolder(view) {
    val EventImage = view.findViewById<ImageView>(R.id.PopularCardImage)
    val EventTitle = view.findViewById<TextView>(R.id.PopularCardTitle)
    val EventDay = view.findViewById<TextView>(R.id.PopularCardDay)
    val EventMonth = view.findViewById<TextView>(R.id.PopularCardMonth)
    val EventCategory = view.findViewById<TextView>(R.id.PopularCardCategory)
    val EventPrice = view.findViewById<TextView>(R.id.PopularCardPrice)
    val EventSpace = view.findViewById<TextView>(R.id.PopularCardSpace)
}