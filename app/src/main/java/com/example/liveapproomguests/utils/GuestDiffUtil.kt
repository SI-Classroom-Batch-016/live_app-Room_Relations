package com.example.liveapproomguests.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.liveapproomguests.data.model.Guest

class GuestDiffUtil : DiffUtil.ItemCallback<Guest>() {
    override fun areItemsTheSame(oldItem: Guest, newItem: Guest): Boolean {

        return (oldItem.id == newItem.id)

    }

    override fun areContentsTheSame(oldItem: Guest, newItem: Guest): Boolean {
        return (oldItem.food == newItem.food && oldItem.name == newItem.name)
    }
}