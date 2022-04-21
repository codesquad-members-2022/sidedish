package com.example.sidedish.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.sidedish.R
import com.example.sidedish.data.FoodImage
import com.example.sidedish.databinding.FragmentDetailBinding

class MenuDetailFragment : Fragment() {

    private val binding: FragmentDetailBinding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }

    private val viewModel: MenuListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = mutableListOf<FoodImage>()

        viewModel.selectedFoodDetail.observe(viewLifecycleOwner) { detail ->
            with(binding) {
                foodDetail = detail
                Glide.with(this@MenuDetailFragment).load(detail.detailSection[0]).into(ivDetail1)
                Glide.with(this@MenuDetailFragment).load(detail.detailSection[1]).into(ivDetail2)
                Glide.with(this@MenuDetailFragment).load(detail.detailSection[2]).into(ivDetail3)
                imageList.add(FoodImage(detail.thumbImage[0]))
                imageList.add(FoodImage(detail.thumbImage[1]))
                val adapter = ImageViewPagerAdapter().apply {
                    submitList(imageList)
                }
                pagerDetailImage.adapter = adapter
            }
        }
    }
}