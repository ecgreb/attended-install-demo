package com.example.installtest

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        install_app_button.setOnClickListener {
            val uri = Uri.parse("market://details?id=com.boxed.prod")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.android.vending")
            startActivity(intent)
        }
    }
}
