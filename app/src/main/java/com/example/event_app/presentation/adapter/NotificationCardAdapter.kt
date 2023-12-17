package com.example.event_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R
import com.example.event_app.data.datasource.NotificationCardDataSource
import com.example.event_app.data.models.NotificationCardModel
import com.example.event_app.domain.holder.NotificationCardViewHolder
import com.example.event_app.presentation.fragments.NotificationsFragment

class NotificationCardAdapter(
    private var context : NotificationsFragment,
    private var dataset: MutableList<NotificationCardModel>) : RecyclerView.Adapter<NotificationCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.notification_card_item, parent, false)

        return NotificationCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: NotificationCardViewHolder, position: Int) {
        holder.NotificationImage.setImageResource(dataset[position].NotificationImage)
        holder.NotificationTitle.text = context.resources.getString(dataset[position].NotificationTitle)
        holder.NotificationTime.text = context.resources.getString(dataset[position].NotificationDate)
    }


}