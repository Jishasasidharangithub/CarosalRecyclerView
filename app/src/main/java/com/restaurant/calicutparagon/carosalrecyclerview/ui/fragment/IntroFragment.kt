package com.restaurant.calicutparagon.ae.ui.fragment.onbody

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.restaurant.calicutparagon.carosalrecyclerview.R
import com.restaurant.calicutparagon.carosalrecyclerview.databinding.FragmentIntroBinding
import com.restaurant.calicutparagon.carosalrecyclerview.ui.adapter.IntroItemAdapter
import com.restaurant.calicutparagon.carosalrecyclerview.ui.modelclass.IntroItem


class IntroFragment : Fragment() {

    private var binding: FragmentIntroBinding? = null
    private val introItemAdapter: IntroItemAdapter by lazy { IntroItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window
            .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        setData()
        init()
        showLayout()
    }

    private fun updateRecyclerViewPosition(position: Int) {
        binding?.rvImage?.smoothScrollToPosition(position)
    }

    private fun showLayout() {
        // Check if the binding object is not null
        binding?.let { bind ->
            // Set click listener for btLoginRegister button
            bind.btLoginRegister.setOnClickListener {
                if (bind.cslLogin.visibility == View.GONE) {
                    bind.cslLogin.visibility = View.VISIBLE
                    bind.cslWelcomeBack.visibility = View.GONE
                    updateRecyclerViewPosition(1) // Update RecyclerView to the first item
                }
            }
            bind.ivArrow.setOnClickListener {
                if (bind.cslLogin.visibility == View.VISIBLE) {
                    bind.cslLogin.visibility = View.GONE
                    bind.cslWelcomeBack.visibility = View.VISIBLE
                    updateRecyclerViewPosition(0) // Update RecyclerView to the first item
                }
            }

            // Set click listener for btNext button
            bind.btNext.setOnClickListener {
                if (bind.cslVerifyOtp.visibility == View.GONE) {
                    bind.cslVerifyOtp.visibility = View.VISIBLE
                    bind.cslLogin.visibility = View.GONE
                    updateRecyclerViewPosition(2) // Update RecyclerView to the second item
                }
            }
            bind.ivArrowVerifyOtp.setOnClickListener {
                if (bind.cslVerifyOtp.visibility == View.VISIBLE) {
                    bind.cslVerifyOtp.visibility = View.GONE
                    bind.cslLogin.visibility = View.VISIBLE
                    updateRecyclerViewPosition(1) // Update RecyclerView to the first item
                }
            }
            bind.btnSubmit.setOnClickListener {
                findNavController().navigate(R.id.homeFragment)
            }
        }
    }

    private fun init() {
        binding?.rvImage?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = introItemAdapter
            setIntervalRatio(0.79f)
            //addOnScrollListener(recyclerViewScrollListener)

        }
    }

    private fun setData() {
        val data = listOf(
            IntroItem(R.drawable.image),
            IntroItem(R.drawable.image2),
            IntroItem(R.drawable.image3)
        )
        introItemAdapter.updateData(data)


    }
}