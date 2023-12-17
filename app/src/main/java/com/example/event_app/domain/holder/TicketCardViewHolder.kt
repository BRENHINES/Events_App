package com.example.event_app.domain.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R

class TicketCardViewHolder (private var view : View) : RecyclerView.ViewHolder(view) {
    val TicketEventImage = view.findViewById<ImageView>(R.id.TicketCardImage)
    val TicketEventTitle = view.findViewById<TextView>(R.id.TicketCardTitle)
    val TicketEventDay = view.findViewById<TextView>(R.id.TicketCardDay)
    val TicketEventMonth = view.findViewById<TextView>(R.id.TicketCardMonth)
    val TicketEventCategory = view.findViewById<TextView>(R.id.TicketCardCategory)
}