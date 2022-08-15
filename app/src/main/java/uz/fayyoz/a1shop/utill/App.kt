package uz.fayyoz.a1shop.utill

import android.app.Application
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import uz.fayyoz.a1shop.utill.network.ConnectivityReceiver
import uz.fayyoz.a1shop.utill.network.NetworkListener

class App : Application() {
    private val connectionReceiver by lazy(LazyThreadSafetyMode.NONE) { ConnectivityReceiver() }

    companion object {
        lateinit var appInstance: App
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            NetworkListener(this).startNetworkCallback()
        else
            registerReceiver(
                connectionReceiver,
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
    }

    override fun onTerminate() {
        super.onTerminate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            NetworkListener(this).stopNetworkCallback()
        else
            unregisterReceiver(connectionReceiver)
    }
}