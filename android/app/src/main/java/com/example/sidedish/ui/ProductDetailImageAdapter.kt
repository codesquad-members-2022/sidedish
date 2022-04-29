package com.example.sidedish.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sidedish.databinding.ItemProductDetailImageBinding
import com.example.sidedish.model.RepresentImages

class ProductDetailImageAdapter :
    ListAdapter<RepresentImages, ProductDetailImageAdapter.ProductDetailImageViewHolder>(
        ProductDetailImageDiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductDetailImageViewHolder {
        val binding = ItemProductDetailImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductDetailImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductDetailImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductDetailImageViewHolder(private val binding: ItemProductDetailImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(representImages: RepresentImages) {
            binding.representImages = representImages
            binding.executePendingBindings()
        }
    }
}

object ProductDetailImageDiffCallback : DiffUtil.ItemCallback<RepresentImages>() {
    override fun areItemsTheSame(
        oldItem: RepresentImages,
        newItem: RepresentImages
    ): Boolean {
        return oldItem.imageId == newItem.imageId
    }

    override fun areContentsTheSame(
        oldItem: RepresentImages,
        newItem: RepresentImages
    ): Boolean {
        return oldItem == newItem
    }
}