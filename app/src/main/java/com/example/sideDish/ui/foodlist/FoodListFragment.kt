package com.example.sideDish.ui.foodlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sideDish.common.EventObserver
import com.example.sideDish.R
import com.example.sideDish.common.ViewModelFactory
import com.example.sideDish.data.FoodCategory
import com.example.sideDish.data.source.FoodRepository
import com.example.sideDish.ui.productdetail.ProductDetailFragment

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
            this,
            ViewModelFactory(FoodRepository())
        ).get(FoodListViewModel::class.java)

        val adapter = FoodListAdapter(viewModel)
        recyclerView.adapter = adapter

        viewModel.mainItems.observe(viewLifecycleOwner) {
            adapter.setItems(FoodCategory.MAIN, it)
        }

        viewModel.soupItems.observe(viewLifecycleOwner) {
            adapter.setItems(FoodCategory.SOUP, it)
        }

        viewModel.sideItems.observe(viewLifecycleOwner) {
            adapter.setItems(FoodCategory.SIDE, it)
        }

        viewModel.getMainItems()
        viewModel.getSoupItems()
        viewModel.getSideItems()

        viewModel.openDetail.observe(viewLifecycleOwner, EventObserver {
            openDetail()
        })

        return layout
    }

    private fun openDetail() {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.container, ProductDetailFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}