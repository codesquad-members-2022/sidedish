package com.example.sidedish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sidedish.databinding.ItemMenuDataBinding

class MainHomeAdapter : ListAdapter<Products, MainHomeHolder>(diffUtil) {

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
    fun bind(menuList: Products) {
        binding.menuData = menuList
    }
}

private val diffUtil = object : DiffUtil.ItemCallback<Products>() {
    override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem == newItem
    }
}