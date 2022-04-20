package com.example.sidedish.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sidedish.data.Header
import com.example.sidedish.databinding.FragmentMainBinding
import com.example.sidedish.ui.adapter.MenuListAdapter

class SideMenuFragment : Fragment() {
    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val viewModel:MenuListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sideMenuAdapter = MenuListAdapter(Header.SIDE)

        with(binding) {
            rvMain.adapter = sideMenuAdapter
            rvMain.layoutManager = LinearLayoutManager(activity)
        }

        viewModel.sideFoodList.observe(viewLifecycleOwner) {
            sideMenuAdapter.submitList(it)
        }
    }

}