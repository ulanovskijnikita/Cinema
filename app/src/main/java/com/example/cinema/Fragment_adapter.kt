package com.example.cinema

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Fragment_adapter(val con: Context, val list: List<fragment_data>): RecyclerView.Adapter<Fragment_adapter.Link>() {
    class Link(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fragment_img: ImageView = itemView.findViewById(R.id.recycler_fragment_films_image)
        val fragment_text: TextView = itemView.findViewById(R.id.recycler_fragment_films_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Fragment_adapter.Link {
        val root = LayoutInflater.from(con).inflate(R.layout.recycler_fragment_films, parent, false)
        return Link(root)
    }

    override fun onBindViewHolder(holder: Fragment_adapter.Link, position: Int) {
        holder.fragment_img.setImageResource(list[position].img_frament)
        holder.fragment_text.setText(list[position].text_frament)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}