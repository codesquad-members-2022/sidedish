package com.codesquadhan.sidedish.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codesquadhan.sidedish.data.model.DetailImage
import com.codesquadhan.sidedish.databinding.ItemDetailBinding

class DetailAdapter : ListAdapter<DetailImage, DetailAdapter.DetailViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding = ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DetailViewHolder(private val binding: ItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(detailImage: DetailImage) {
            binding.detailImage = detailImage

            Glide.with(binding.root)
                .load(detailImage.imagePath)
                .centerCrop()
                .into(binding.ivFoodDetail)
        }

    }

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<DetailImage>() {
            override fun areItemsTheSame(oldItem: DetailImage, newItem: DetailImage): Boolean {
                return oldItem.menuId == newItem.menuId
            }

            override fun areContentsTheSame(oldItem: DetailImage, newItem: DetailImage): Boolean {
                return oldItem == newItem
            }
        }
    }
}
