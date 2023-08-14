package com.restaurant.calicutparagon.ae.ui.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.restaurant.calicutparagon.carosalrecyclerview.R
import com.restaurant.calicutparagon.carosalrecyclerview.databinding.FragmentCartDialogBinding
import com.restaurant.calicutparagon.carosalrecyclerview.ui.adapter.CartDialogItemAdapter
import com.restaurant.calicutparagon.carosalrecyclerview.ui.modelclass.CartDialogItem

class CartDialogFragment : DialogFragment() {
    private var binding: FragmentCartDialogBinding? = null
    private val cartDialogItemAdapter: CartDialogItemAdapter by lazy { CartDialogItemAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCartDialogBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        binding?.rvAddress?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cartDialogItemAdapter
            setData()
        }
        // Set dialog layout parameters to position at the bottom
        val layoutParams = dialog?.window?.attributes
        layoutParams?.gravity = Gravity.BOTTOM
        dialog?.window?.attributes = layoutParams

    }

    private fun setData() {
        val data = listOf(
            CartDialogItem(R.drawable.ic_work,"Home","Test Location, Al Nadha, Dubai"),
            CartDialogItem(R.drawable.ic_work,"Work","Test Location, Al Nadha, Dubai"),
            CartDialogItem(R.drawable.ic_work,"Work","Test Location, Al Nadha, Dubai"),
        )

        cartDialogItemAdapter.updateData(data)
    }
    companion object {
        fun newInstance(): CartDialogFragment {
            return CartDialogFragment()
        }
    }
}

