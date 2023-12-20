package com.projectname
import android.view.View
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager
import javax.inject.Inject

class BridgePackage @Inject constructor(
) : ReactPackage {
    val modules: MutableList<NativeModule> = mutableListOf()

    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        modules.clear()
        modules.add(NativeBridgeModule(reactContext))
        return modules
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<View, ReactShadowNode<*>>> {
        return emptyList<ViewManager<View, ReactShadowNode<*>>>()
    }
}

