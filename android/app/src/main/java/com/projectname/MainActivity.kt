package com.projectname

import android.content.Intent
import android.content.IntentFilter
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate

import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint
import com.facebook.react.defaults.DefaultReactActivityDelegate

class MainActivity : ReactActivity() {

    private val airplaneModeChangeReceiver = AirplaneModeChangeReceiver()

    override fun getMainComponentName(): String = "ProjectName"

    override fun createReactActivityDelegate(): ReactActivityDelegate =
        DefaultReactActivityDelegate(
            this,
            getMainComponentName(),
            DefaultNewArchitectureEntryPoint.fabricEnabled,
            DefaultNewArchitectureEntryPoint.concurrentReactEnabled
        )

    override

    fun

            onStart() {
        super.onStart()
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(airplaneModeChangeReceiver, filter)
    }

    override

    fun

            onStop() {
        super.onStop()
        unregisterReceiver(airplaneModeChangeReceiver)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}