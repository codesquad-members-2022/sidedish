package com.example.sidedish.ui.menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.sidedish.R
import com.example.sidedish.databinding.ActivityHomeBinding
import com.example.sidedish.ui.viewmodel.MenuListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val viewModel:MenuListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d("TAG", "activity viewmodel ${viewModel.hashCode()}")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val code =intent?.data?.getQueryParameter("code")
        if(code != null) {
            viewModel.getJWT(code) {
                findNavController(R.id.loginFragment).navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }
}