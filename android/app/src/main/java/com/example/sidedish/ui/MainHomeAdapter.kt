package com.example.sidedish.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sidedish.R
import com.example.sidedish.databinding.ItemMenuDataBinding
import com.example.sidedish.model.Products

class MainHomeAdapter :
    ListAdapter<Products, MainHomeAdapter.MainHomeHolder>(MainHomeAdapterDiffCallback) {

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

    class MainHomeHolder(private val binding: ItemMenuDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(products: Products) {
            binding.products = products
            itemView.setOnClickListener {
                Intent(it.context, ProductDetailActivity::class.java).apply {
                    putExtra("product", products)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { it.context.startActivity(this) }
            }
        }
    }
}

object MainHomeAdapterDiffCallback : DiffUtil.ItemCallback<Products>() {
    override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem == newItem
    }
}