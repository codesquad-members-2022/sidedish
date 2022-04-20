package com.example.sidedish.ui.adapter

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sidedish.data.Body
import com.example.sidedish.databinding.ItemFoodListBinding

class MenuListAdapter: ListAdapter<Body, MenuListAdapter.FoodListViewHolder>(DiffUtil) {

    lateinit var itemClickCallback: ((key: String) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        val binding = ItemFoodListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Body>() {

        override fun areItemsTheSame(oldItem: Body, newItem: Body): Boolean {
            return oldItem.detailHash == newItem.detailHash
        }

        override fun areContentsTheSame(oldItem: Body, newItem: Body): Boolean {
            return oldItem == newItem
        }

    }

    inner class FoodListViewHolder(private val binding: ItemFoodListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(menu: Body) {
            with(binding) {
                Glide.with(itemView).load(menu.image).into(imMenuImage)
                tvMenuLabel.text = menu.alt
                tvMenuInfo.text = menu.description
                tvAfterCost.text = menu.sPrice
                if(menu.nPrice != null) {
                    setSale(menu)
                }
            }

            itemView.setOnClickListener {
                menu.detailHash?.let { key -> itemClickCallback.invoke(key) }
            }
        }

        private fun setSale(menu: Body) {
            with(binding) {
                tvBeforeCost.visibility = View.VISIBLE
                tvBeforeCost.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                tvBeforeCost.text = menu.nPrice
                setBadge(menu.badge?.get(0) ?: "none")
            }
        }

        private fun setBadge(sale: String) {
            when(sale) {
                "런칭특가" -> {
                    binding.tvLaunchingCostBadge.visibility = View.VISIBLE
                }
                "이벤트특가" -> {
                    binding.tvLimitedCostBadge.visibility = View.VISIBLE
                }
                else -> {
                    Log.e("Adapter", "setBadge none")
                }
            }
        }
    }
}