package com.example.events.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.event_app.R
import com.example.event_app.presentation.fragments.HomeFragment
import com.example.events.data.models.TagModel
import com.example.events.domain.holder.TagViewHolder

class TagAdapter(
    private val context: HomeFragment,
    private val dataset: MutableList<TagModel>) :
    RecyclerView.Adapter<TagViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.tag_item, parent, false)

        return TagViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.tagText.text = context.resources.getString(dataset[position].tagText)
    }


}