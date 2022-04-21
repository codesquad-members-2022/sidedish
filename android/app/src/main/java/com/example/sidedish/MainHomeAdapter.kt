package com.example.sidedish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sidedish.databinding.ItemMenuDataBinding

class MainHomeAdapter : ListAdapter<MenuData, MainHomeHolder>(diffUtil) {

    override fun onBindViewHolder(holder: MainHomeHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<ItemMenuDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_menu_data,
            parent,
            false
        ).let {
            MainHomeHolder(it)
        }
}

class MainHomeHolder(private val binding: ItemMenuDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(menuList: MenuData) {
        binding.menuData = menuList
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