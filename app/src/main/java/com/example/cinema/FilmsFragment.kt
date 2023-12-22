package com.example.cinema

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class FilmsFragment : Fragment() {

    private lateinit var rV:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_films, container, false)

        rV = root.findViewById(R.id.fragment_films_recycler)
        rV.adapter=Fragment_adapter(requireContext(), fragment_list().f_list)

        return root
    }
}