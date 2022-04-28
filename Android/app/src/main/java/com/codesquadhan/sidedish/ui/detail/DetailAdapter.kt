package com.codesquadhan.sidedish.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.data.model.DetailImage
import com.codesquadhan.sidedish.data.model.detail.TopImageData
import com.codesquadhan.sidedish.databinding.ItemDetailBinding
import com.codesquadhan.sidedish.ui.common.LoadedImageFailListener

class DetailAdapter : ListAdapter<TopImageData, DetailAdapter.DetailViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding = ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(getItem(position).imageUrl)
    }

    class DetailViewHolder(private val binding: ItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imageUrl: String) {

            Glide.with(binding.root)
                .load(imageUrl)
                .thumbnail(Glide.with(binding.root.context).load(R.drawable.loading_icon))
                .listener(LoadedImageFailListener(binding.ivFoodDetailFail))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivFoodDetail)
        }

    }

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<TopImageData>() {
            override fun areItemsTheSame(oldItem: TopImageData, newItem: TopImageData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TopImageData, newItem: TopImageData): Boolean {
                return oldItem == newItem
            }
        }
    }
}
