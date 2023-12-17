package com.example.event_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R
import com.example.event_app.data.models.EventCardModel
import com.example.event_app.domain.holder.EventCardViewHolder
import com.example.event_app.presentation.fragments.HomeFragment

class EventCardAdapter (
    private val context : HomeFragment,
    private val dataset : MutableList<EventCardModel>) :

    RecyclerView.Adapter<EventCardViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventCardViewHolder {
            val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.event_card_item, parent, false)

            return EventCardViewHolder(adapterLayout)
        }

        override fun getItemCount(): Int {
            return dataset.size
        }

        override fun onBindViewHolder(holder: EventCardViewHolder, position: Int) {
            holder.EventImage.setImageResource(dataset[position].EventImage)
            holder.EventTitle.text = context.resources.getString(dataset[position].EventTitle)
            holder.EventCategory.text = context.resources.getString(dataset[position].EventCategory)
            holder.EventDay.text = context.resources.getString(dataset[position].EventDay)
            holder.EventMonth.text = context.resources.getString(dataset[position].EventMonth)
            holder.EventSpace.text = context.resources.getString(dataset[position].EventSpace)
            holder.EventPrice.text = context.resources.getString(dataset[position].EventPrice)
        }

}