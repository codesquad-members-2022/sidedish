package com.example.sidedish.ui.menu

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sidedish.data.Header
import com.example.sidedish.databinding.FragmentMainBinding
import com.example.sidedish.ui.viewmodel.MenuListViewModel
import com.example.sidedish.ui.adapter.MenuListAdapter

class SoupMenuFragment : MenuFragment() {

    override fun setAdapter(
        binding: FragmentMainBinding,
        viewModel: MenuListViewModel
    ): MenuListAdapter {
        val soupFoodAdapter = MenuListAdapter(Header.SOUP, this)

        with(binding) {
            rvMain.adapter = soupFoodAdapter
            rvMain.layoutManager = LinearLayoutManager(activity)
        }
        return soupFoodAdapter
    }

    override fun observe(viewModel: MenuListViewModel, menuAdapter: MenuListAdapter) {
        viewModel.soupFoodList.observe(viewLifecycleOwner) {
            menuAdapter.submitList(it)
        }
    }
}