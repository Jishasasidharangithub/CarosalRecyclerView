package com.restaurant.calicutparagon.carosalrecyclerview.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.restaurant.calicutparagon.carosalrecyclerview.R
import com.restaurant.calicutparagon.carosalrecyclerview.databinding.ActivityMainBinding
import com.restaurant.calicutparagon.carosalrecyclerview.hide
import com.restaurant.calicutparagon.carosalrecyclerview.show
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null
    private var graph: NavGraph? = null

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding?.bottomNav?.menu?.findItem(R.id.homeFragment)?.isChecked = true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        init()
        handleEvents()
    }
    private fun init() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val inflater = navHostFragment?.navController?.navInflater
        graph = inflater?.inflate(R.navigation.my_nav)
        setDestination()
    }
    private fun setDestination() {

        graph?.setStartDestination( R.id.homeFragment)
        navController = navHostFragment?.navController
        graph?.let { navController?.setGraph(it, intent.extras) }

    }
    private fun handleEvents() {
        binding?.bottomNav?.setOnItemSelectedListener {
            if (navController?.currentDestination?.id != it.itemId)
                navController?.navigate(it.itemId)
            false
        }

        navController?.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.ordersFragment, R.id.profileFragment -> {
                    binding?.bottomNav?.menu?.findItem(destination.id)?.isChecked = true
                    lifecycleScope.launch {
                        delay(100)
                        binding?.bottomNav?.show()
                    }
                }

                else -> binding?.bottomNav?.hide()
            }

        }
    }
}