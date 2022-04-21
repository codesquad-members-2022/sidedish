package com.example.sidedish.ui.menu

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sidedish.data.Header
import com.example.sidedish.databinding.FragmentMainBinding
import com.example.sidedish.ui.viewmodel.MenuListViewModel
import com.example.sidedish.ui.adapter.MenuListAdapter


class MainMenuFragment : MenuFragment() {

    override fun setAdapter(binding: FragmentMainBinding, viewModel: MenuListViewModel): MenuListAdapter {
        val mainFoodAdapter = MenuListAdapter(Header.MAIN, this)

        with(binding) {
            rvMain.adapter = mainFoodAdapter
            rvMain.layoutManager = LinearLayoutManager(activity)
        }

        return mainFoodAdapter
    }

    override fun observe(viewModel: MenuListViewModel, menuAdapter: MenuListAdapter) {
        viewModel.mainFoodList.observe(viewLifecycleOwner) {
            menuAdapter.submitList(it)
        }
    }
}