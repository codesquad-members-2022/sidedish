package com.codesquadhan.sidedish.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import com.codesquadhan.sidedish.databinding.ItemMainFoodBinding
import com.codesquadhan.sidedish.databinding.ItemMainHeaderBinding
import com.codesquadhan.sidedish.ui.common.ViewType.FOOD_VIEW_TYPE
import com.codesquadhan.sidedish.ui.common.ViewType.HEADER_VIEW_TYPE

class MainAdapter(private val itemClick: (id: Int) -> Unit) :
    ListAdapter<MainResponseItem, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_VIEW_TYPE -> {
                val binding = ItemMainHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                MainHeaderViewHolder(binding)
            }
            FOOD_VIEW_TYPE -> {
                val binding =
                    ItemMainFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MainFoodViewHolder(binding)
            }
            else -> {
                throw RuntimeException("Invalid ViewHolder Type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)

        when (currentItem.viewType) {
            HEADER_VIEW_TYPE -> (holder as MainHeaderViewHolder).bind(currentItem)
            FOOD_VIEW_TYPE -> (holder as MainFoodViewHolder).bind(currentItem, itemClick)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    class MainHeaderViewHolder(private val binding: ItemMainHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mainResponseItem: MainResponseItem) {
            binding.mainResponseItem = mainResponseItem
            binding.tvMainHeader.text = mainResponseItem.headerText

            binding.tvItemCount.text = binding.root.context.getString(
                R.string.header_item_count,
                mainResponseItem.itemCount
            )
            binding.tvItemCount.isVisible = mainResponseItem.isHeaderClicked
            binding.root.setOnClickListener {
                binding.tvItemCount.isVisible = true
//                getItem(position).isHeaderClicked = true
                mainResponseItem.isHeaderClicked = true
            }
        }

    }

    class MainFoodViewHolder(private val binding: ItemMainFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mainResponseItem: MainResponseItem, itemClick: (id: Int) -> Unit) {
            binding.mainResponseItem = mainResponseItem

            Glide.with(binding.root)
                .load(mainResponseItem.imagePath).error(R.drawable.ic_launcher_foreground)
                .into(binding.ivFood)

            binding.root.setOnClickListener {
                itemClick.invoke(mainResponseItem.id)
            }
        }
    }

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<MainResponseItem>() {
            override fun areItemsTheSame(
                oldItem: MainResponseItem,
                newItem: MainResponseItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MainResponseItem,
                newItem: MainResponseItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}