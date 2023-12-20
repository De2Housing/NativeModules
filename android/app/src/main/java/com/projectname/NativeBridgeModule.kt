package com.projectname

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import java.security.Permissions


class NativeBridgeModule(
    val reactContext: ReactApplicationContext,
) : ReactContextBaseJavaModule(reactContext) {

    override fun canOverrideExistingModule(): Boolean {
        return true
    }

    override fun getName(): String {
        return "NativeBridgeModule"
    }

    @ReactMethod
     fun isMediaPermissionGranted(callback: Callback)  {
        val context: Context = reactApplicationContext
        val activity = currentActivity ?: return
        var isGranted = true
        val permission = Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED
//        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
        isGranted = ActivityCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED
        if (!isGranted) {
                ActivityCompat.requestPermissions(
                activity,
                arrayOf(permission),
                148
            )
        }
//        }
        if (isGranted) {
            callback.invoke()
        } else {
        }
    }
}
