package com.example.liveapproomguests.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.liveapproomguests.databinding.GuestItemBinding

class GuestAdapter(
    val dataset: List<*>,
) : RecyclerView.Adapter<GuestAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: GuestItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = GuestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]


    }

}