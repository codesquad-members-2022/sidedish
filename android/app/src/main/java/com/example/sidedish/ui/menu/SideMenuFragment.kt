package com.example.sidedish.ui.menu

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sidedish.data.Header
import com.example.sidedish.databinding.FragmentMainBinding
import com.example.sidedish.ui.viewmodel.MenuListViewModel
import com.example.sidedish.ui.adapter.MenuListAdapter

class SideMenuFragment : MenuFragment() {

    override fun setAdapter(
        binding: FragmentMainBinding,
        viewModel: MenuListViewModel
    ): MenuListAdapter {
        val sideMenuAdapter = MenuListAdapter(Header.SIDE, this)

        with(binding) {
            rvMain.adapter = sideMenuAdapter
            rvMain.layoutManager = LinearLayoutManager(activity)
        }
        return sideMenuAdapter
    }

    override fun observe(viewModel: MenuListViewModel, menuAdapter: MenuListAdapter) {
        viewModel.sideFoodList.observe(viewLifecycleOwner) {
            menuAdapter.submitList(it)
        }
    }

}