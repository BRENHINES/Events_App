package com.example.events.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R
import com.example.event_app.presentation.fragments.HomeFragment
import com.example.events.data.models.PopularCardModel
import com.example.events.domain.holder.PopularCardViewHolder

class PopularCardAdapter(
    private val context : HomeFragment,
    private val dataset : MutableList<PopularCardModel>) :
    RecyclerView.Adapter<PopularCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.popular_card_item, parent, false)

        return PopularCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: PopularCardViewHolder, position: Int) {
        holder.popularEventImage.setImageResource(dataset[position].popularEventImage)
        holder.popularEventTitle.text = context.resources.getString(dataset[position].popularEventTitle)
        holder.popularEventCategory.text = context.resources.getString(dataset[position].popularEventCategory)
        holder.popularEventDay.text = context.resources.getString(dataset[position].popularEventDay)
        holder.popularEventMonth.text = context.resources.getString(dataset[position].popularEventMonth)
    }
}