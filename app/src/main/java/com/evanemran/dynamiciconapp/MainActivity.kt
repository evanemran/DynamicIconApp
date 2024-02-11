package com.evanemran.dynamiciconapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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


        binding.buttonOne.setOnClickListener {
            aliasManager.clearApiKey()
            val iconChangeIntent = Intent("com.evanemran.dynamiciconapp.ACTION_CHANGE_ICON")
            sendBroadcast(iconChangeIntent)
            aliasManager.selectedAlias = getString(R.string.alias_1)
            Toast.makeText(this, getString(R.string.alias_1), Toast.LENGTH_SHORT).show()
        }

        binding.buttonTwo.setOnClickListener {
            aliasManager.clearApiKey()
            val iconChangeIntent = Intent("com.evanemran.dynamiciconapp.ACTION_CHANGE_ICON")
            sendBroadcast(iconChangeIntent)
            aliasManager.selectedAlias = getString(R.string.alias_2)
            Toast.makeText(this, getString(R.string.alias_2), Toast.LENGTH_SHORT).show()
        }
    }
}