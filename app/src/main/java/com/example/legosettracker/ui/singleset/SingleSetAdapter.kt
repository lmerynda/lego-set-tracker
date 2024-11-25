package com.example.legosettracker.ui.singleset

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.legosettracker.LegoSetItem
import com.example.legosettracker.R

class SingleSetAdapter : RecyclerView.Adapter<SingleSetAdapter.ViewHolder>() {
    private var items: List<LegoSetItem> = emptyList()

    fun updateItems(newItems: List<LegoSetItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_in_lego_set, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.singleItemLabel)
        private val totalCount: TextView = itemView.findViewById(R.id.brickCount)
        private val bricksCollected: TextView = itemView.findViewById(R.id.bricksCollected)

        fun bind(item: LegoSetItem) {
            title.text = item.brickName
            totalCount.text = "Total: ${item.totalCount}"
            bricksCollected.text = "Collected: ${item.bricksCollected}"
        }
    }
}