package com.example.liveapproomguests.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.liveapproomguests.data.model.Guest
import com.example.liveapproomguests.databinding.GuestItemBinding
import com.example.liveapproomguests.utils.GuestDiffUtil

class GuestAdapter(
    val onGuestClicked: (Guest) -> Unit
) : ListAdapter<Guest ,GuestAdapter.ItemViewHolder>(GuestDiffUtil()) {

    inner class ItemViewHolder(val binding: GuestItemBinding) : RecyclerView.ViewHolder(binding.root)


    fun sortItems(){
        val sortedList = currentList.sortedBy { it.food }
        submitList(sortedList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = GuestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = currentList[position]

        holder.binding.guestNameTV.text = item.name
        holder.binding.guestFoodTV.text = item.food

        holder.binding.guestCV.setOnClickListener {
            onGuestClicked(item)
        }
    }

}