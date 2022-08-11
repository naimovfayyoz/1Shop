package uz.fayyoz.a1shop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.NavHostFragment
import uz.fayyoz.a1shop.R
import androidx.navigation.NavController
import uz.fayyoz.a1shop.data.local.pref.UserPref
import uz.fayyoz.a1shop.databinding.ActivityMainBinding
import uz.fayyoz.a1shop.utill.isNull
import uz.fayyoz.a1shop.utill.network.Variables
import uz.fayyoz.a1shop.utill.showSnackbar


class MainActivity : AppCompatActivity() {
    private var isFirstNetworkCheck = true
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        val userPref = UserPref(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        lifecycleScope.launch {
//            userPref.clear()
//        }
        userPref.accessToken.asLiveData().observe(this)
        {
            setupNavigation(it.isNull())
        }

        Variables.isNetworkConnected.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let { isNetworkAvailable ->
                if (isNetworkAvailable) {
                    onNetworkAvailable()
                } else
                    onNetworkLost()
            }
        })
    }

    private fun onNetworkAvailable() {
        if (!isFirstNetworkCheck)
            binding.root.showSnackbar("😃 Yeay network is back")
        isFirstNetworkCheck = false
    }

    private fun onNetworkLost() {
        binding.root.showSnackbar("☹ Woops!! Looks like we lost network")
    }

    private fun setupNavigation(isAuthorized: Boolean) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.main_graph)
        if (isAuthorized) {
            navGraph.setStartDestination(R.id.loginFragment)

        } else {
            navGraph.setStartDestination(R.id.mainFragment)
        }
        navController.graph = navGraph
    }
}
