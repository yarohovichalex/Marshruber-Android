package com.github.yarohovichalex.marshruber.android.navigation.rider

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.github.yarohovichalex.marshruber.android.navigation.rider.databinding.ActivityNavigationRiderBinding

abstract class RiderNavigationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = getAppFragmentFactory()
        super.onCreate(savedInstanceState)

        ActivityNavigationRiderBinding.inflate(LayoutInflater.from(this))
                .also { binding ->
                    setContentView(binding.root)
                    setSupportActionBar(binding.toolbar)
                }

        navController = Navigation.findNavController(this, R.id.navHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean =
            navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    protected abstract fun getAppFragmentFactory(): FragmentFactory
}
