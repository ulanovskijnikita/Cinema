package com.example.cinema

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class filmsFragments(fa: filmsActivity, private val list:List<Fragment>):FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}