package com.example.sidedish.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.sidedish.R
import com.example.sidedish.databinding.FragmentHomeBinding
import com.example.sidedish.ui.MenuItemClickListener
import com.example.sidedish.ui.adapter.MenuListAdapter
import com.example.sidedish.ui.adapter.MenuPageAdapter
import com.example.sidedish.ui.animation.ZoomOutPageTransformer
import com.example.sidedish.ui.viewmodel.MenuListViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val NUM_PAGES = 3

@AndroidEntryPoint
class HomeFragment : Fragment(), MenuItemClickListener {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val viewModel: MenuListViewModel by viewModels()

//    private val viewPager: ViewPager2 by lazy {
//        binding.pager
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val screenList = listOf(MainMenuFragment(), SoupMenuFragment(), SideMenuFragment())
//        viewPager.adapter =
//            activity?.let {
//                ScreenSlidePagerAdapter(
//                    it.supportFragmentManager,
//                    lifecycle,
//                    screenList
//                )
//            }
//
//        viewPager.setPageTransformer(ZoomOutPageTransformer())
        val adapter = MenuPageAdapter(this)
        binding.rvMenuListView.adapter = adapter
        binding.rvMenuListView.layoutManager = LinearLayoutManager(binding.root.context)
        viewModel.menu.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(binding.root.context, viewModel.error.value, Toast.LENGTH_SHORT).show()
        }
    }

    override fun itemClickCallback(key: Int) {
        viewModel.loadFoodDetail(key)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
    }

//    private inner class ScreenSlidePagerAdapter(
//        fm: FragmentManager,
//        lifecycle: Lifecycle,
//        private val list: List<MenuFragment>
//    ) : FragmentStateAdapter(fm, lifecycle) {
//        override fun getItemCount(): Int = NUM_PAGES
//
//        override fun createFragment(position: Int): MenuFragment {
//            return list[position]
//        }
//    }

}