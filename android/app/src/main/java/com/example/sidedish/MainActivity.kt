package com.example.sidedish

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sidedish.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mainAdapter = MainHomeAdapter()
        val soupAdapter = MainHomeAdapter()
        val sideAdapter = MainHomeAdapter()

        binding.recyclerviewMainlist.adapter = mainAdapter
        binding.recyclerviewSouplist.adapter = soupAdapter
        binding.recyclerviewSidelist.adapter = sideAdapter

        mainAdapter.submitList(mainPut())
        soupAdapter.submitList(soupPut())
        sideAdapter.submitList(sidePut())

        val count1 = mainAdapter.itemCount.toString()
        binding.headerSub1.text = "${count1}개 상품이 등록되어 있습니다."

        val count2 = soupAdapter.itemCount.toString()
        binding.headerSub2.text = "${count2}개 상품이 등록되어 있습니다."

        val count3 = sideAdapter.itemCount.toString()
        binding.headerSub3.text = "${count3}개 상품이 등록되어 있습니다."

        binding.headerTitle1.setOnClickListener {
            if (binding.headerSub1.visibility == View.GONE) {
                binding.headerSub1.visibility = View.VISIBLE
            } else
                binding.headerSub1.visibility = View.GONE
        }

        binding.headerTitle2.setOnClickListener {
            if (binding.headerSub2.visibility == View.GONE) {
                binding.headerSub2.visibility = View.VISIBLE
            } else
                binding.headerSub2.visibility = View.GONE
        }

        binding.headerTitle3.setOnClickListener {
            if (binding.headerSub3.visibility == View.GONE) {
                binding.headerSub3.visibility = View.VISIBLE
            } else
                binding.headerSub3.visibility = View.GONE
        }
    }
}