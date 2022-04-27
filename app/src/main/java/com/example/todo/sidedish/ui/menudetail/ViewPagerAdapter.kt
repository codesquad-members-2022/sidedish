package com.example.todo.sidedish.ui.menudetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.sidedish.databinding.ItemViewpagerBinding

class ViewPagerAdapter() :RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>(){

    private val sliderImages = mutableListOf<String>()
    class ViewHolder(private val binding: ItemViewpagerBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(imageUri:String){
            binding.thumbnail= imageUri
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sliderImages[position])
    }

    override fun getItemCount(): Int {
        return sliderImages.size
    }

    fun submitThumbnails(thumbnails:List<String>){
        this.sliderImages.addAll(thumbnails)
        notifyDataSetChanged()
    }
}