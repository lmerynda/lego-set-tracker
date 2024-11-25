package com.example.legosettracker.ui.singleset

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.legosettracker.R

class SingleSetAdapter : RecyclerView.Adapter<SingleSetAdapter.MyViewHolder>() {
    private var items: List<LegoSetItem> = emptyList()

    fun updateItems(newItems: List<LegoSetItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_lego_set, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.singleItemLabel)

        fun bind(item: LegoSetItem) {
            title.text = item.brickName
        }
    }
}