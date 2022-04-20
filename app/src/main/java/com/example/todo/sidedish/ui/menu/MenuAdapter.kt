package com.example.todo.sidedish.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.sidedish.common.Constants.VIEW_TYPE_HEADER
import com.example.todo.sidedish.common.Constants.VIEW_TYPE_ITEM
import com.example.todo.sidedish.databinding.ItemHeaderBinding
import com.example.todo.sidedish.databinding.ItemMenuBinding
import com.example.todo.sidedish.domain.model.Header
import com.example.todo.sidedish.domain.model.Menu
import com.example.todo.sidedish.domain.model.MenuItem

class MenuAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var menuItems = mutableListOf<MenuItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> HeaderViewHolder(ItemHeaderBinding.inflate(inflater, parent, false))
            else -> ItemViewHolder(ItemMenuBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                val item = menuItems[position] as Header
                holder.bind(item)
            }
            is ItemViewHolder -> {
                val item = menuItems[position] as Menu
                holder.bind(item)
            }
        }
    }

    override fun getItemCount(): Int = menuItems.size

    override fun getItemViewType(position: Int): Int {
        return when (menuItems[position]) {
            is Header -> VIEW_TYPE_HEADER
            else -> VIEW_TYPE_ITEM
        }
    }

    fun submitHeaderAndItemList(items: Map<String, List<Menu>?>) {
        val menuItems = mutableListOf<MenuItem>()
        items.entries.forEach { entry ->
            val header = Header(entry.key)
            menuItems.add(header)
            entry.value?.let { menuItems.addAll(it) }
        }
        this.menuItems = menuItems
        notifyDataSetChanged()
    }

    inner class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(header: Header) {
            binding.header = header
            binding.executePendingBindings()
        }
    }

    inner class ItemViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Menu) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}