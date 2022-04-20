package com.example.sidedish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sidedish.databinding.HomeListBinding

class MainHomeAdapter : ListAdapter<MenuData, MainHomeAdapter.MainHomeHolder>(diffUtil) {
    inner class MainHomeHolder(private val binding: HomeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuList: MenuData) {
            binding.menuData = menuList
        }
    }

    override fun onBindViewHolder(holder: MainHomeHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<HomeListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_menu_data,
            parent,
            false
        ).let {
            MainHomeHolder(it)
        }
}

private val diffUtil = object : DiffUtil.ItemCallback<MenuData>() {
    override fun areItemsTheSame(oldItem: MenuData, newItem: MenuData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MenuData, newItem: MenuData): Boolean {
        return oldItem == newItem
    }
}