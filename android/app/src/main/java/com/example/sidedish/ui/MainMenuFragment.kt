package com.example.sidedish.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sidedish.R
import com.example.sidedish.databinding.FragmentMainBinding
import com.example.sidedish.ui.adapter.MenuListAdapter

class MainMenuFragment : Fragment() {

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
        val mainFoodAdapter = MenuListAdapter()
        mainFoodAdapter.itemClickCallback = { key: String ->
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }

        with(binding) {
            rvMain.adapter = mainFoodAdapter
            rvMain.layoutManager = LinearLayoutManager(activity)
        }

        viewModel.mainFoodList.observe(viewLifecycleOwner) {
            mainFoodAdapter.submitList(it)
        }
    }
}