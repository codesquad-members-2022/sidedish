package com.example.todo.sidedish.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.todo.sidedish.R
import com.example.todo.sidedish.databinding.FragmentMenuBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private val viewModel: MenuViewModel by viewModels()
    private lateinit var binding: FragmentMenuBinding
    private lateinit var navigator: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigator= Navigation.findNavController(view)
        val adapter = MenuAdapter{it->
            navigator.navigate(R.id.action_menuFragment_to_menuDetailFragment, bundleOf("detailHash" to it))
        }

        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvMenu.adapter = adapter
        viewModel.menus.observe(viewLifecycleOwner) { menus ->
            adapter.submitHeaderAndItemList(menus)
        }
    }
}