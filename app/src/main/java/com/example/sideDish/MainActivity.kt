package com.example.sideDish

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.sideDish.ui.foodlist.FoodListFragment
import com.example.sideDish.ui.productdetail.ProductDetailFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState != null) {
            val lastFragment = savedInstanceState.getInt("lastFragment")

            if (lastFragment == 1) supportFragmentManager.commit {
                replace(
                    R.id.container,
                    ProductDetailFragment()
                )
            }
            else if (lastFragment == 2) supportFragmentManager.commit {
                replace(
                    R.id.container,
                    FoodListFragment()
                )
            }
        } else supportFragmentManager.commit { replace(R.id.container, FoodListFragment()) }
    }
}