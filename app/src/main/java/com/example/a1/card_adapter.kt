package com.example.a1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class card_adapter(val con:Context, val list: List<card_data>):RecyclerView.Adapter<card_adapter.Link>() {
    class Link(itemView: View):RecyclerView.ViewHolder(itemView) {
        val card:ImageView=itemView.findViewById(R.id.recycler_card_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): card_adapter.Link {
        val root=LayoutInflater.from(con).inflate(R.layout.recycler_cards, parent, false)
        return Link(root)
    }

    override fun onBindViewHolder(holder: card_adapter.Link, position: Int) {
        holder.card.setImageResource(list[position].img_card)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}