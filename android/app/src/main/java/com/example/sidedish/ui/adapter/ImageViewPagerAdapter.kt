package com.example.sidedish.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sidedish.data.FoodImage
import com.example.sidedish.databinding.ItemThumbnailBinding

class ImageViewPagerAdapter :
    ListAdapter<FoodImage, ImageViewPagerAdapter.ImageViewHolder>(DiffUtil) {

    class ImageViewHolder(val binding: ItemThumbnailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodImage: FoodImage) {
            with(binding) {
                Log.d("TAG", "viewholder ${foodImage.thumbnailImage}")
                Glide.with(itemView).load(foodImage.thumbnailImage).into(ivThumbnail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val thumbnailBinding =
            ItemThumbnailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(thumbnailBinding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<FoodImage>() {

        override fun areItemsTheSame(oldItem: FoodImage, newItem: FoodImage): Boolean {
            return oldItem.thumbnailImage == newItem.thumbnailImage
        }

        override fun areContentsTheSame(oldItem: FoodImage, newItem: FoodImage): Boolean {
            return oldItem == newItem
        }

    }

}