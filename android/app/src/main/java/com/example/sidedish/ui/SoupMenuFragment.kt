package com.example.sidedish.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sidedish.data.Header
import com.example.sidedish.databinding.FragmentMainBinding
import com.example.sidedish.ui.adapter.MenuListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SoupMenuFragment : Fragment() {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MenuListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val soupFoodAdapter = MenuListAdapter(Header.SOUP)

        with(binding) {
            rvMain.adapter = soupFoodAdapter
            rvMain.layoutManager = LinearLayoutManager(activity)
        }

        viewModel.soupFoodList.observe(viewLifecycleOwner) {
            soupFoodAdapter.submitList(it)
        }
    }
}