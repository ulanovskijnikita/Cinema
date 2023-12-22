package com.example.cinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val con:Context, private val list: List<CardData>):RecyclerView.Adapter<CardAdapter.Link>() {
    class Link(itemView: View):RecyclerView.ViewHolder(itemView) {
        val card:ImageView=itemView.findViewById(R.id.recycler_card_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Link {
        val root=LayoutInflater.from(con).inflate(R.layout.recycler_cards, parent, false)
        return Link(root)
    }

    override fun onBindViewHolder(holder: Link, position: Int) {
        holder.card.setImageResource(list[position].cardImg)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}