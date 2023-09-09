package com.ereyes.horoscapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ereyes.horoscapp.R
import com.ereyes.horoscapp.domain.model.HoroscopeInfo

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.ui.horoscope.adapter
 * Created by Edgar Reyes Gonzalez on 9/9/2023 at 2:10 PM
 * All rights reserved 2023.
 ****/
class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected: (HoroscopeInfo) -> Unit
) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected)
    }

    override fun getItemCount() = horoscopeList.size

    fun updateList(list: List<HoroscopeInfo>) {
        horoscopeList = list
        notifyDataSetChanged()
    }

}