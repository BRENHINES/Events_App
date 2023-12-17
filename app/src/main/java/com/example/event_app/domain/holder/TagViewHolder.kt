package com.example.events.domain.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R

class TagViewHolder (private val view : View) : RecyclerView.ViewHolder(view) {
    val tagText = view.findViewById<TextView>(R.id.tagText)
}