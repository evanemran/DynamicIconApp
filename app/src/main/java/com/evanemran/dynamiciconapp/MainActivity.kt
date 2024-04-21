package com.evanemran.dynamiciconapp

import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.evanemran.dynamiciconapp.databinding.ActivityMainBinding


public lateinit var aliasManager: KeyManager
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        aliasManager = KeyManager(this)

        aliasManager.selectedAlias.let {
            binding.textViewAlias.text = it
        }

//        val pm: PackageManager = packageManager
//        pm.setComponentEnabledSetting(
//            ComponentName(this, getString(R.string.alias_1)),
//            PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
//        ) // Disable one alias


        binding.buttonOne.setOnClickListener {
            aliasManager.clearApiKey()
//            val intentFilter: IntentFilter = IntentFilter()
//            intentFilter.addAction("com.evanemran.dynamiciconapp.ACTION_CHANGE_ICON")
//            val iconChangeIntent = Intent("com.evanemran.dynamiciconapp.ACTION_CHANGE_ICON")
//            sendBroadcast(iconChangeIntent)
            aliasManager.selectedAlias = getString(R.string.alias_1)
//            setIconOne()
            Toast.makeText(this, getString(R.string.alias_1), Toast.LENGTH_SHORT).show()
        }

        binding.buttonTwo.setOnClickListener {
            aliasManager.clearApiKey()
//            val iconChangeIntent = Intent("com.evanemran.dynamiciconapp.ACTION_CHANGE_ICON")
//            sendBroadcast(iconChangeIntent)
            aliasManager.selectedAlias = getString(R.string.alias_2)
//            setIconTwo()
            Toast.makeText(this, getString(R.string.alias_2), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        aliasManager.selectedAlias.let {
            if (it == getString(R.string.alias_1)) {
                setIconOne()
            }
            else if (it == getString(R.string.alias_2)) {
                setIconTwo()
            }
        }
        super.onStop()
    }

    private fun setIconOne() {
        val pm = packageManager
        pm.setComponentEnabledSetting(
            ComponentName(
                this,
                "com.evanemran.dynamiciconapp.MainActivityAlias"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
        pm.setComponentEnabledSetting(
            ComponentName(
                this,
                "com.evanemran.dynamiciconapp.MainActivityAliasTwo"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    private fun setIconTwo() {
        val pm = packageManager
        pm.setComponentEnabledSetting(
            ComponentName(
                this,
                "com.evanemran.dynamiciconapp.MainActivityAliasTwo"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
        pm.setComponentEnabledSetting(
            ComponentName(
                this,
                "com.evanemran.dynamiciconapp.MainActivityAlias"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}