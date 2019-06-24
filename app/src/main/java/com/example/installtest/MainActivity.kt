package com.example.installtest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val packageObserver = PackageObserver()
        packageObserver.register(this)

        install_app_button.setOnClickListener {
            val uri = Uri.parse("market://details?id=com.boxed.prod")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.android.vending")
            startActivity(intent)
        }
    }

    class PackageObserver : BroadcastReceiver() {

        fun register(context: Context) {
            val intentFilter = IntentFilter(Intent.ACTION_PACKAGE_ADDED)
            intentFilter.addDataScheme("package")
            context.registerReceiver(this, intentFilter)
        }

        override fun onReceive(context: Context?, intent: Intent?) {
            if ("package:com.boxed.prod" == intent?.data?.toString()) {
                val uri = Uri.parse("boxedwholesale://variants_gid/51?utm_source=button&utm_medium=affiliate&utm_campaign=button&btn_ref=srctok-1234567890abcdef_ca")
                val i = Intent(Intent.ACTION_VIEW, uri)
                context?.startActivity(i)
            }
        }
    }
}
