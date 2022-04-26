package com.example.sideDish.ui.foodlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sideDish.R
import com.example.sideDish.common.EventObserver
import com.example.sideDish.common.ViewModelFactory
import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.ui.productdetail.ProductDetailFragment
import kotlinx.coroutines.launch

class FoodListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: FoodListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_food_list, container, false)
        recyclerView = layout.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelFactory()
        ).get(FoodListViewModel::class.java)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = FoodListAdapter(viewModel)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.items.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewLifecycleOwner.lifecycleScope.launch() {
            launch { adapter.updateCategoryItems(FoodCategory.MAIN) }.join()
            launch { adapter.updateCategoryItems(FoodCategory.SOUP) }.join()
            launch { adapter.updateCategoryItems(FoodCategory.SIDE) }.join()
        }

        viewModel.openDetail.observe(viewLifecycleOwner, EventObserver {
            openDetail()
        })
    }

    private fun openDetail() {
        parentFragmentManager.commit {
            addToBackStack(null)
            replace(R.id.container, ProductDetailFragment())
        }
    }
}