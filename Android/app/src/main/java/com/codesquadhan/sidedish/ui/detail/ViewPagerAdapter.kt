package com.codesquadhan.sidedish.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.codesquadhan.sidedish.R
import com.codesquadhan.sidedish.data.model.be.MainResponseItem
import com.codesquadhan.sidedish.data.model.detail.TopImageData
import com.codesquadhan.sidedish.databinding.ItemViewpagerImageBinding
import com.codesquadhan.sidedish.ui.common.LoadedImageFailListener

class ViewPagerAdapter() :
    ListAdapter<TopImageData, ViewPagerAdapter.PagerViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding = ItemViewpagerImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PagerViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        Log.d("AppTest", "viewpagerAdapter onBindViewHolder")
        holder.bind(getItem(position).imageUrl)
    }

    class PagerViewHolder(private val binding: ItemViewpagerImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imageUrl: String) {
            Log.d("AppTest", "imageUrl : $imageUrl")
            // Glide 써주기
            Glide.with(binding.root)
                .load(imageUrl)
                .thumbnail(Glide.with(binding.root.context).load(R.drawable.loading_icon))
                .listener(LoadedImageFailListener(binding.ivDetailFail))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivDetail)
        }
    }


    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<TopImageData>() {
            override fun areItemsTheSame(
                oldItem: TopImageData,
                newItem: TopImageData
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TopImageData,
                newItem: TopImageData
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}