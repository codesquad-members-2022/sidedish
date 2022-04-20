package com.example.sideDish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CardListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_card_list, container, false)
        recyclerView = layout.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(FoodRepository())
        ).get(MainViewModel::class.java)

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