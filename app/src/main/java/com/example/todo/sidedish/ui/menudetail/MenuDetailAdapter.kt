package com.example.todo.sidedish.ui.menudetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.sidedish.databinding.ItemDetailImageBinding

class MenuDetailAdapter() :RecyclerView.Adapter<MenuDetailAdapter.ViewHolder>(){

    private val detailImages = mutableListOf<String>()
    class ViewHolder(private val binding: ItemDetailImageBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(imageUri:String){
            binding.details= imageUri
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDetailImageBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(detailImages[position])
    }

    fun submitDetailImages(detailImages:List<String>){
        this.detailImages.addAll(detailImages)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return detailImages.size
    }
}