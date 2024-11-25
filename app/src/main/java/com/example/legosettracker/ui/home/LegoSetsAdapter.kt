package com.example.legosettracker.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.legosettracker.R
import com.example.legosettracker.ui.singleset.SingleSet

class LegoSetsAdapter : RecyclerView.Adapter<LegoSetsAdapter.ViewHolder>() {
    private var items: List<SingleSet> = emptyList()

    fun updateItems(newItems: List<SingleSet>) {
        Log.d("LegoSetsAdapter", "Updating items: ${newItems.size}")
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_set_in_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.singleSetTitle)

        fun bind(item: SingleSet) {
            title.text = item.title
        }
    }
}
