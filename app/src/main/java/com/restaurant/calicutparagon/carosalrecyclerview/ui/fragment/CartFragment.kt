package com.restaurant.calicutparagon.ae.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.restaurant.calicutparagon.carosalrecyclerview.R
import com.restaurant.calicutparagon.carosalrecyclerview.databinding.FragmentCartBinding
import com.restaurant.calicutparagon.carosalrecyclerview.ui.adapter.CartItemAdapter
import com.restaurant.calicutparagon.carosalrecyclerview.ui.modelclass.CartItem

class CartFragment : Fragment() {

    private var binding: FragmentCartBinding? = null
    private val cartItemAdapter: CartItemAdapter by lazy { CartItemAdapter() }
    private val cartItems = mutableListOf<CartItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(
            LayoutInflater.from(requireContext()), container, false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        handleEvents()
    }

    private fun handleEvents() {
        binding?.cvDeliveryTo?.setOnClickListener{
            val dialogFragment = CartDialogFragment.newInstance()
            dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.YourDialogStyle)
            dialogFragment.show(childFragmentManager, "my_dialog")
        }
    }


    private fun initView() {
        binding?.includeToolBar?.tvToolbarHead?.text = "Cart"
        binding?.rvCart?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = cartItemAdapter
            cartData()
        }
    }

    private fun cartData() {
        cartItems.addAll(listOf(CartItem("1 x Chicken Biriyani","Full","AED 10"), CartItem("Fish Fry", "Full","AED 30")))
        cartItemAdapter.updateList(cartItems)
    }
}