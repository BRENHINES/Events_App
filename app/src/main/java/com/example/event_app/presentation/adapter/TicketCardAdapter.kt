package com.example.event_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R
import com.example.event_app.data.models.TicketCardModel
import com.example.event_app.domain.holder.TicketCardViewHolder
import com.example.event_app.presentation.fragments.TicketFragment
import com.example.events.domain.holder.PopularCardViewHolder

class TicketCardAdapter(
    private val context : TicketFragment,
    private val dataset : MutableList<TicketCardModel>) : RecyclerView.Adapter<TicketCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.ticket_card_item, parent, false)

        return TicketCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: TicketCardViewHolder, position: Int) {
        holder.TicketEventImage.setImageResource(dataset[position].TicketEventImage)
        holder.TicketEventTitle.text = context.resources.getString(dataset[position].TicketEventTitle)
        holder.TicketEventCategory.text = context.resources.getString(dataset[position].TicketEventCategory)
        holder.TicketEventDay.text = context.resources.getString(dataset[position].TicketEventDay)
        holder.TicketEventMonth.text = context.resources.getString(dataset[position].TicketEventMonth)
    }

}