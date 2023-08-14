package com.restaurant.calicutparagon.carosalrecyclerview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.restaurant.calicutparagon.carosalrecyclerview.databinding.ItemDialogueCartBinding
import com.restaurant.calicutparagon.carosalrecyclerview.ui.modelclass.CartDialogItem

class CartDialogItemAdapter: RecyclerView.Adapter<CartDialogItemAdapter.ViewHolder>() {
    private val itemList = mutableListOf<CartDialogItem>()


    class ViewHolder(val binding: ItemDialogueCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDialogueCartBinding.inflate(
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
            holder.binding.ivOffice.setImageResource(image)
            holder.binding.tvOffice.text = title
            holder.binding.tvOfficeAddress.text = address


        }
    }
    fun updateData(list: List<CartDialogItem>) {
        itemList.clear()
        itemList.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }


}