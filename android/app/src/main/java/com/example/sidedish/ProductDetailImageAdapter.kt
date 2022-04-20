package com.example.sidedish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sidedish.databinding.ItemPorductDetailImageBinding

class ProductDetailImageAdapter :
    ListAdapter<ProductDetailImageList, ProductDetailImageAdapter.ProductDetailImageViewHolder>(
        ProductDetailImageDiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductDetailImageViewHolder {
        val binding = ItemPorductDetailImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductDetailImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductDetailImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductDetailImageViewHolder(private val binding: ItemPorductDetailImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productDetailImageList: ProductDetailImageList) {
            binding.image = productDetailImageList
            binding.executePendingBindings()
        }
    }
}

object ProductDetailImageDiffCallback : DiffUtil.ItemCallback<ProductDetailImageList>() {
    override fun areItemsTheSame(
        oldItem: ProductDetailImageList,
        newItem: ProductDetailImageList
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProductDetailImageList,
        newItem: ProductDetailImageList
    ): Boolean {
        return oldItem == newItem
    }
}