package com.example.sidedish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sidedish.databinding.ItemPorductDetailImageBinding

class ProductDetailImageAdapter :
    ListAdapter<ProductDetailTitleImageList, ProductDetailImageAdapter.ProductDetailImageViewHolder>(
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
        fun bind(productDetailTitleImageList: ProductDetailTitleImageList) {
            binding.image = productDetailTitleImageList
            binding.executePendingBindings()
        }
    }
}

object ProductDetailImageDiffCallback : DiffUtil.ItemCallback<ProductDetailTitleImageList>() {
    override fun areItemsTheSame(
        oldItem: ProductDetailTitleImageList,
        newItem: ProductDetailTitleImageList
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProductDetailTitleImageList,
        newItem: ProductDetailTitleImageList
    ): Boolean {
        return oldItem == newItem
    }
}