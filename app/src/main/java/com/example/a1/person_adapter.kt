package com.example.a1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class person_adapter(val con: Context, val list: List<person_data>): RecyclerView.Adapter<person_adapter.Link>() {
    class Link(itemView: View): RecyclerView.ViewHolder(itemView) {
        val person_img: ImageView =itemView.findViewById(R.id.recycler_person_image)
        val person_name: TextView =itemView.findViewById(R.id.recycler_person_name)
        val person_txt: TextView =itemView.findViewById(R.id.recycler_person_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): person_adapter.Link {
        val root= LayoutInflater.from(con).inflate(R.layout.recycler_person, parent, false)
        return Link(root)
    }

    override fun onBindViewHolder(holder: person_adapter.Link, position: Int) {
        holder.person_img.setImageResource(list[position].img_person)
        holder.person_name.setText(list[position].name_person)
        holder.person_txt.setText(list[position].text_person)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}