package com.example.sidedish.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sidedish.R
import com.example.sidedish.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val mainAdapter = MainHomeAdapter()
        val soupAdapter = MainHomeAdapter()
        val sideAdapter = MainHomeAdapter()

        binding.rvMainlist.adapter = mainAdapter.apply {
            viewModel.mainMenu.observe(this@MainActivity) {
                submitList(it)
            }
        }
        binding.rvSidelist.adapter = soupAdapter.apply {
            viewModel.soupMenu.observe(this@MainActivity) {
                submitList(it)
            }
        }
        binding.rvSouplist.adapter = sideAdapter.apply {
            viewModel.sideDish.observe(this@MainActivity) {
                submitList(it)
            }
        }

        viewModel.error.observe(this) {
            Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT).show()
        }

        binding.tvHeaderTitle1.setOnClickListener {
            if (binding.tvHeaderSub1.visibility == View.GONE) {
                binding.tvHeaderSub1.visibility = View.VISIBLE
            } else
                binding.tvHeaderSub1.visibility = View.GONE
        }

        binding.tvHeaderTitle2.setOnClickListener {
            if (binding.tvHeaderSub2.visibility == View.GONE) {
                binding.tvHeaderSub2.visibility = View.VISIBLE
            } else
                binding.tvHeaderSub2.visibility = View.GONE
        }

        binding.tvHeaderTitle3.setOnClickListener {
            if (binding.tvHeaderSub3.visibility == View.GONE) {
                binding.tvHeaderSub3.visibility = View.VISIBLE
            } else
                binding.tvHeaderSub3.visibility = View.GONE
        }
    }
}