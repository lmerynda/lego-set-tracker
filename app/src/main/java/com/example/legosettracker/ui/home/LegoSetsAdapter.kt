package com.example.legosettracker.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.legosettracker.R
import com.example.legosettracker.LegoSet

class LegoSetsAdapter(private val onItemClick: (LegoSet) -> Unit) : RecyclerView.Adapter<LegoSetsAdapter.ViewHolder>() {
    private var items: List<LegoSet> = emptyList()

    fun updateItems(newItems: List<LegoSet>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_set_in_list, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View, private val onItemClick: (LegoSet) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.singleSetTitle)
        private val count: TextView = itemView.findViewById(R.id.singleSetCount)

        fun bind(item: LegoSet) {
            title.text = item.title
            count.text = "Total brics: ${item.getBricksCount()}"
            itemView.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}
