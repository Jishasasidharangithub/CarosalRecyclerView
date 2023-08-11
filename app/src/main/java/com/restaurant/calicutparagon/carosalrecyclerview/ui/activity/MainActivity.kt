package com.restaurant.calicutparagon.carosalrecyclerview.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.restaurant.calicutparagon.carosalrecyclerview.R
import com.restaurant.calicutparagon.carosalrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null
    private var graph: NavGraph? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
    private fun init() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val inflater = navHostFragment?.navController?.navInflater
        graph = inflater?.inflate(R.navigation.my_nav)
        setDestination()
    }
    private fun setDestination() {

        graph?.setStartDestination( R.id.introFragment)
        navController = navHostFragment?.navController
        graph?.let { navController?.setGraph(it, intent.extras) }


    }
}