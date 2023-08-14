package com.restaurant.calicutparagon.carosalrecyclerview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.restaurant.calicutparagon.carosalrecyclerview.databinding.ItemCartBinding
import com.restaurant.calicutparagon.carosalrecyclerview.ui.modelclass.CartItem

class CartItemAdapter(): RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {

    private val cartItems = mutableListOf<CartItem>()
    inner class CartItemViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        return CartItemViewHolder(
            ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        with(cartItems[position]) {
            holder.binding.tvCartItem.text = title
            holder.binding.tvQuantity.text = quantity
            holder.binding.tvAED.text = aed.toString()
        }
    }
    fun updateList(list: List<CartItem>) {
        cartItems.clear()
        cartItems.addAll(list)
        notifyDataSetChanged()
    }

}