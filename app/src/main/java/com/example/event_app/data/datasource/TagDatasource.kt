package com.example.events.data.data

import android.annotation.SuppressLint
import com.example.event_app.R
import com.example.events.data.models.TagModel

class TagDatasource {
    @SuppressLint("ResourceType")
    fun loadTag() :MutableList<TagModel> {
        return mutableListOf(
            TagModel(
                R.string.approved
            ),
            TagModel(
                R.id.sign_up
            ),
            TagModel(
                R.id.sign_up
            ),
            TagModel(
                R.id.sign_up
            ),
            TagModel(
                R.id.sign_up
            ),
            TagModel(
                R.id.sign_up
            ),
            TagModel(
                R.id.sign_up
            ),
            TagModel(
                R.id.sign_up
            ),
            TagModel(
                R.id.sign_up
            ),
        )
    }
}