package com.example.myassssmentapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DashboardAdapter(
    private val itemList: List<DashboardItem>,
    private val onItemClick: (DashboardItem) -> Unit
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvOrigin: TextView = view.findViewById(R.id.tvOrigin)

        init {
            view.setOnClickListener {
                onItemClick(itemList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dashboard, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.tvName.text = item.name
        holder.tvOrigin.text = item.culture
    }
}
