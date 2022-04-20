package com.example.sideDish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val viewModel = ViewModelProvider(
            this,
            ViewModelFactory(FoodRepository())
        ).get(MainViewModel::class.java)

        val adapter = FoodListAdapter()
        recyclerView.adapter = adapter

        viewModel.mainItems.observe(this) {
            adapter.setItems(FoodCategory.MAIN, it)
        }

        viewModel.soupItems.observe(this) {
            adapter.setItems(FoodCategory.SOUP, it)
        }

        viewModel.sideItems.observe(this) {
            adapter.setItems(FoodCategory.SIDE, it)
        }

        viewModel.getMainItems()
        viewModel.getSoupItems()
        viewModel.getSideItems()
    }
}