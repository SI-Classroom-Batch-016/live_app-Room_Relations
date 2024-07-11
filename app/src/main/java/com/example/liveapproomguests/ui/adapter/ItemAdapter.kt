package com.example.liveapproomguests.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.liveapproomguests.data.model.Buch
import com.example.liveapproomguests.data.model.Leser
import com.example.liveapproomguests.data.model.LeserMitBuchListe
import com.example.liveapproomguests.databinding.ListItemBinding

class ItemAdapter(
    val dataset: List<LeserMitBuchListe>,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.itemTV.text = item.leser.name + item.buchListe.toString()

    }

}