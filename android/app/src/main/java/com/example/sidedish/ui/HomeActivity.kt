package com.example.sidedish.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.sidedish.databinding.ActivityHomeBinding

private const val NUM_PAGES = 3

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
//    private val viewPager: ViewPager2 by lazy {
//        binding.pager
//    }

    private val viewModel: MenuListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        viewPager.adapter = ScreenSlidePagerAdapter(this)
//        viewPager.setPageTransformer(ZoomOutPageTransformer())
    }

//    override fun onBackPressed() {
//        if (viewPager.currentItem == 0) {
//            super.onBackPressed()
//        } else {
//            viewPager.currentItem = viewPager.currentItem - 1
//        }
//    }

//    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
//        override fun getItemCount(): Int = NUM_PAGES
//
//        override fun createFragment(position: Int): Fragment {
//            return when (position) {
//                0 -> MainFragment()
//                1 -> SoupFragment()
//                2 -> SideFragment()
//                else -> throw IndexOutOfBoundsException("fragment out bound")
//            }
//        }
//    }
}