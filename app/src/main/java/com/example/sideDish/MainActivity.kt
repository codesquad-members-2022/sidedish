package com.example.sideDish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sideDish.ui.foodlist.FoodListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, FoodListFragment())
        transaction.commit()
    }
}