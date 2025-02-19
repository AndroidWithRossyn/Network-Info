package com.rohitrajkhorwal.network

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Extension function to check if the device has an active network connection
 * @return Boolean indicating if network is available
 */
@SuppressLint("ObsoleteSdkInt")
fun Context.isNetworkConnected(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager ?: return false

    return when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> {
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.let { capabilities ->
                capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                        capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) &&
                        (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
                                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) ||
                                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN))
            } ?: false
        }
        else -> {
            @Suppress("DEPRECATION")
            connectivityManager.activeNetworkInfo?.isConnectedOrConnecting == true
        }
    }
}

/**
 * Extension function to check network connection type
 * @return NetworkType enum indicating connection type
 */
@SuppressLint("ObsoleteSdkInt")
fun Context.getNetworkType(): NetworkType {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager ?: return NetworkType.NONE

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.let { capabilities ->
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> NetworkType.WIFI
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> NetworkType.CELLULAR
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> NetworkType.ETHERNET
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> NetworkType.VPN
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> NetworkType.BLUETOOTH
                else -> NetworkType.NONE
            }
        }
    } else {
        @Suppress("DEPRECATION")
        when (connectivityManager.activeNetworkInfo?.type) {
            ConnectivityManager.TYPE_WIFI -> return NetworkType.WIFI
            ConnectivityManager.TYPE_MOBILE -> return NetworkType.CELLULAR
            ConnectivityManager.TYPE_ETHERNET -> return NetworkType.ETHERNET
            ConnectivityManager.TYPE_BLUETOOTH -> return NetworkType.BLUETOOTH
            ConnectivityManager.TYPE_VPN -> return NetworkType.VPN
        }
    }

    return NetworkType.NONE
}

/**
 * Enum representing different network connection types
 */
enum class NetworkType {
    WIFI, CELLULAR, ETHERNET, BLUETOOTH, VPN, NONE
}

/**
 * Extension function to register for network callbacks
 * @param onAvailable callback when network becomes available
 * @param onLost callback when network is lost
 * @return NetworkCallback instance that can be used to unregister
 */
@SuppressLint("ObsoleteSdkInt")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.registerNetworkCallback(
    onAvailable: () -> Unit,
    onLost: () -> Unit
): ConnectivityManager.NetworkCallback {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            onAvailable()
        }

        override fun onLost(network: Network) {
            onLost()
        }
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    } else {
        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(request, networkCallback)
    }

    return networkCallback
}

/**
 * Extension function to unregister network callback
 * @param callback The NetworkCallback to unregister
 */
@SuppressLint("ObsoleteSdkInt")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Context.unregisterNetworkCallback(callback: ConnectivityManager.NetworkCallback) {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    connectivityManager.unregisterNetworkCallback(callback)
}