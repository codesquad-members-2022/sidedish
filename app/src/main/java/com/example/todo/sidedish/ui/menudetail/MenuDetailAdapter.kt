package com.example.todo.sidedish.ui.menudetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.sidedish.common.GlideApp
import com.example.todo.sidedish.databinding.ItemDetailImageBinding

class MenuDetailAdapter() :RecyclerView.Adapter<MenuDetailAdapter.ViewHolder>(){

    private val sliderImages = mutableListOf<String>()
    class ViewHolder(private val binding: ItemDetailImageBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(imageUri:String){
            binding.imageUri= imageUri
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDetailImageBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sliderImages[position])
    }

    fun submitDetailImages(detailImages:List<String>){
        this.sliderImages.addAll(detailImages)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return sliderImages.size
    }
}