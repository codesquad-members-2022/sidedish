package com.example.sidedish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sidedish.databinding.HomeListBinding

class MainHomeAdapter : ListAdapter<MenuList, MainHomeAdapter.MainHomeHolder>(diffUtil) {
    inner class MainHomeHolder(private val binding: HomeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuList: MenuList) {
            binding.menuXml = menuList
        }
    }

    override fun onBindViewHolder(holder: MainHomeHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<HomeListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.home_list,
            parent,
            false
        ).let {
            MainHomeHolder(it)
        }
}

private val diffUtil = object : DiffUtil.ItemCallback<MenuList>() {
    override fun areItemsTheSame(oldItem: MenuList, newItem: MenuList): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MenuList, newItem: MenuList): Boolean {
        return oldItem == newItem
    }
}