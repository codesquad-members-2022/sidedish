package com.example.sideDish.ui.foodlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sideDish.R
import com.example.sideDish.common.EventObserver
import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.ui.productdetail.ProductDetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.lang.Exception

@AndroidEntryPoint
class FoodListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel by viewModels<FoodListViewModel>()
    private lateinit var adapter: FoodListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_food_list, container, false)
        recyclerView = layout.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FoodListAdapter(viewModel)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.items.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        showSideDishList()
        viewModel.openDetail.observe(viewLifecycleOwner, EventObserver {
            openDetail()
        })
    }

    private fun showSideDishList() {
        val ceh = CoroutineExceptionHandler { _, exception ->
            Log.d(TAG, "$exception")
            Toast.makeText(requireContext(), "반찬의 일부를 가져오지 못했습니다", Toast.LENGTH_SHORT).show()
        }
        viewLifecycleOwner.lifecycleScope.launch(ceh) {
            supervisorScope {
                launch() {
                    adapter.updateCategoryItems(FoodCategory.MAIN)
                }.join()
                launch() {
                    //throw Exception()
                    adapter.updateCategoryItems(FoodCategory.SOUP)
                }.join()
                launch() {
                    adapter.updateCategoryItems(FoodCategory.SIDE)
                }.join()
            }

        }
    }

    private fun openDetail() {
        parentFragmentManager.commit {
            addToBackStack(null)
            replace(R.id.container, ProductDetailFragment())
        }
    }

    companion object {
        const val TAG = "FoodListFragment"
    }
}