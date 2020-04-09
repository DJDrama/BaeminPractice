package com.dj.baeminpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var currentNavController: LiveData<NavController> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            setUpBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpBottomNavigationBar()
    }

    private fun setUpBottomNavigationBar(){
        bottomNavigationView = findViewById(R.id.bottom_nav)

        val navGraphIds = listOf(
            R.navigation.nav_home,
            R.navigation.nav_eat_what,
            R.navigation.nav_favorite,
            R.navigation.nav_order,
            R.navigation.nav_profile
        )
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds, supportFragmentManager, R.id.nav_host_fragment_container, intent
        )
        currentNavController = controller
    }
}