package com.restaurant.calicutparagon.carosalrecyclerview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.restaurant.calicutparagon.carosalrecyclerview.databinding.ItemIntroImageBinding
import com.restaurant.calicutparagon.carosalrecyclerview.ui.modelclass.IntroItem


class IntroItemAdapter(): RecyclerView.Adapter<IntroItemAdapter.ViewHolder>() {
    private val itemList = mutableListOf<IntroItem>()
    private var selectedItemPosition: Int = RecyclerView.NO_POSITION


    class ViewHolder(val binding: ItemIntroImageBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ItemIntroImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            with(itemList[position]) {
                holder.binding.ivIntroImage.setImageResource(img)
            }
        }
            fun updateData(list: List<IntroItem>) {
                itemList.clear()
                itemList.addAll(list)
                notifyItemRangeChanged(0, list.size)
            }


}