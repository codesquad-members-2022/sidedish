package com.example.sideDish.ui.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sideDish.R
import com.example.sideDish.databinding.ItemSliderBinding

class ImageSliderAdapter(private val imageUrlList: List<String>) :
    RecyclerView.Adapter<ImageSliderAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            binding.url = url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_slider,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imageUrlList[position])
    }

    override fun getItemCount(): Int = imageUrlList.size

}