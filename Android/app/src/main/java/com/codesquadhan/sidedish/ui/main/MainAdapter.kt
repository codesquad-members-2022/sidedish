package com.codesquadhan.sidedish.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codesquadhan.sidedish.data.Menu
import com.codesquadhan.sidedish.databinding.ItemMainFoodBinding
import com.codesquadhan.sidedish.databinding.ItemMainHeaderBinding
import com.codesquadhan.sidedish.ui.constant.ViewType.FOOD_VIEW_TYPE
import com.codesquadhan.sidedish.ui.constant.ViewType.HEADER_VIEW_TYPE
import java.lang.RuntimeException

class MainAdapter : ListAdapter<Menu, RecyclerView.ViewHolder>(diffUtil) {

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
            else -> throw RuntimeException("Invalid ViewHolder Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)

        when (currentItem.viewType) {
            HEADER_VIEW_TYPE -> (holder as MainHeaderViewHolder).bind(currentItem)
            FOOD_VIEW_TYPE -> (holder as MainFoodViewHolder).bind(currentItem)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    class MainHeaderViewHolder(private val binding: ItemMainHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(menu: Menu) {
            binding.menu = menu
            binding.executePendingBindings()
        }
    }

    class MainFoodViewHolder(private val binding: ItemMainFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(menu: Menu) {
            binding.menu = menu
            binding.executePendingBindings()
        }
    }

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Menu>() {
            override fun areItemsTheSame(oldItem: Menu, newItem: Menu): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Menu, newItem: Menu): Boolean {
                return oldItem == newItem
            }
        }
    }

}