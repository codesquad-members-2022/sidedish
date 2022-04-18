package com.codesquadhan.sidedish.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setBtnGitHub()
    }

    fun setBtnGitHub(){
        binding.btnGithub.setOnClickListener {
            binding.clLogin.visibility = View.GONE
            binding.clMain.visibility = View.VISIBLE
        }
    }
}