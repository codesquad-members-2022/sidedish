package com.example.sidedish

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sidedish.ui.MainActivity

class RedirectActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val uri: Uri? = intent.data

        if (uri != null) {
            val intent = Intent(this, MainActivity::class.java)
            val code = uri.getQueryParameter("code")
            intent.putExtra("code", code)
            startActivity(intent)

            finish()
        }

    }
}