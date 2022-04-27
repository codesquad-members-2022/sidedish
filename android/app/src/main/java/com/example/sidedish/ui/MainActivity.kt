package com.example.sidedish.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.sidedish.R
import com.example.sidedish.databinding.ActivityMainBinding
import okhttp3.HttpUrl

class MainActivity : AppCompatActivity() {



    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    companion object {
        const val RESULT_CODE = 10
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signInButton.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        val httpUrl = HttpUrl.Builder()
            .scheme("http")
            .host("github.com")
            .addPathSegment("login")
            .addPathSegment("oauth")
            .addPathSegment("authorize")
            .addQueryParameter("client_id", getString(R.string.github_client_id))
            .addQueryParameter("scope", "user")
            .build()
//            .addQueryParameter("redirect_uri", getString(R.string.github_redirect_url))
        Log.d("TAG", "launch start")
        val intent = Intent(Intent.ACTION_VIEW,Uri.parse(httpUrl.toString()))
        result.launch(intent)
        Log.d("TAG", "launch end")
    }

    private val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        Log.d("TAG", "${it.resultCode}")
        if (it.resultCode == RESULT_CODE) {

        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val code = intent?.getStringExtra("code")
        Log.d("TAG", "${code}")
    }

}