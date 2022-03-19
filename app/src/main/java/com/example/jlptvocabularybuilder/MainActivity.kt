package com.example.jlptvocabularybuilder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.jlptvocabularybuilder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding:ActivityMainBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val view = binding.root
        setSupportActionBar(_binding!!.toolbar)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_controller_view) as NavHostFragment
        val navController =  navHostFragment.navController


        val drawer = binding!!.drawerLayout
        val builder = AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(drawer)
        val appBarConfiguration =  builder.build()
        val navView = _binding!!.navView
        NavigationUI.setupWithNavController(navView, navController)
        _binding!!.toolbar.setupWithNavController(navController,appBarConfiguration)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_controller_view)
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }


}