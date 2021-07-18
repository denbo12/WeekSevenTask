package com.denbofa.weekseventask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denbofa.weekseventask.databinding.ItemStructureBinding

class ItemAdapter( var items: List<ItemModel>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemStructureBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: ItemModel){
            binding.nameDisplay.text = item.name
            binding.priceDisplay.text = item.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemStructureBinding = ItemStructureBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}