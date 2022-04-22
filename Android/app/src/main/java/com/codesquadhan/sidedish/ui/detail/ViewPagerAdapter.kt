package com.codesquadhan.sidedish.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codesquadhan.sidedish.databinding.ItemViewpagerImageBinding

class ViewPagerAdapter(imageUrlList: ArrayList<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    var item = imageUrlList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding = ItemViewpagerImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PagerViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        Log.d("AppTest", "viewpagerAdapter onBindViewHolder")
        holder.bind(item[position])
    }

    class PagerViewHolder(private val binding: ItemViewpagerImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imageUrl: String) {
            Log.d("AppTest", "imageUrl : $imageUrl")
                // Glide 써주기
                Glide.with(binding.root)
                    .load(imageUrl)
                    .into(binding.ivDetail)

        }
    }

    fun updateImageList(newList: ArrayList<String>){
        item.clear()
        item = newList
        notifyDataSetChanged()
    }
}