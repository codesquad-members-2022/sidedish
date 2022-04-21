package com.example.sidedish.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sidedish.R
import com.example.sidedish.databinding.FragmentMainBinding
import com.example.sidedish.ui.MenuItemClickListener
import com.example.sidedish.ui.viewmodel.MenuListViewModel
import com.example.sidedish.ui.adapter.MenuListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class MenuFragment: Fragment(), MenuItemClickListener {

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

        val adapter = setAdapter(binding, viewModel)

        observe(viewModel, adapter)

        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(binding.root.context, viewModel.error.value, Toast.LENGTH_SHORT).show()
        }
    }

    override fun itemClickCallback(key: String) {
        viewModel.loadFoodDetail(key)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
    }

    abstract fun setAdapter(
        binding: FragmentMainBinding,
        viewModel: MenuListViewModel
    ): MenuListAdapter

    abstract fun observe(viewModel: MenuListViewModel, menuAdapter: MenuListAdapter)
}