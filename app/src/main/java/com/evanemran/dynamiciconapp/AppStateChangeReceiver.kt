package com.evanemran.dynamiciconapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AppStateChangeReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(Intent.ACTION_PACKAGE_RESTARTED)) {
            aliasManager.selectedAlias.let {
                if (it == context?.getString(R.string.alias_1)) {
//                    setIconOne()
                }
                else if (it == context?.getString(R.string.alias_2)) {
//                    setIconTwo()
                }
            }
        }
    }
}