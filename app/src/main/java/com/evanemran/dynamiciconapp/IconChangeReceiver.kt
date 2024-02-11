package com.evanemran.dynamiciconapp

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

class IconChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "com.evanemran.dynamiciconapp.ACTION_CHANGE_ICON") {
            changeAppIcon(context)
        }
    }

    private fun changeAppIcon(context: Context?) {
        context?.let { ctx ->
            // Example: Conditionally select a different alias based on some criteria
            val aliasToEnable = when (aliasManager.selectedAlias==context.getString(R.string.alias_2)) {
                true -> ctx.getString(R.string.alias_1)
                false -> ctx.getString(R.string.alias_2)
            }

            val aliasToDisable = when (aliasToEnable) {
                ctx.getString(R.string.alias_1) -> ctx.getString(R.string.alias_2)
                else -> ctx.getString(R.string.alias_1)
            }

            // Change the app icon by enabling one alias and disabling the other
            val packageManager = ctx.packageManager
            enableComponent(ctx, packageManager, aliasToEnable)
            disableComponent(ctx, packageManager, aliasToDisable)
        }
    }

    private fun enableComponent(
        context: Context,
        packageManager: PackageManager,
        componentNameString: String
    ) {
        val componentName = ComponentName(context, componentNameString)

        packageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun disableComponent(
        context: Context,
        packageManager: PackageManager,
        componentNameString: String
    ) {
        val componentName = ComponentName(context, componentNameString)

        packageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}