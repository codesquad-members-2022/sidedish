package com.example.sidedish.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sidedish.R
import com.example.sidedish.data.Category
import com.example.sidedish.data.Menu
import com.example.sidedish.data.MenuModel
import com.example.sidedish.databinding.ItemHeaderBinding
import com.example.sidedish.databinding.ItemMenuListBinding
import com.example.sidedish.ui.MenuItemClickListener
import java.text.DecimalFormat

private const val HEADER = 0
private const val ITEM = 1

class MenuPageAdapter(private val listener: MenuItemClickListener) : ListAdapter<MenuModel, RecyclerView.ViewHolder>(MenuDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> HeaderViewHolder(
                ItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> MenuViewHolder(
                ItemMenuListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HeaderViewHolder -> {
                holder.bind(getItem(position) as Category)
            }
            is MenuViewHolder -> {
                holder.bind(getItem(position) as Menu)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is Category -> HEADER
            is Menu -> ITEM
        }
    }

    inner class MenuViewHolder(private val binding: ItemMenuListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(menu: Menu) {
            val decimal = DecimalFormat("#,###")
            with(binding) {
                Glide.with(itemView).load(menu.mainImageLink).into(imMenuImage)
                tvMenuLabel.text = menu.name
                tvMenuInfo.text = menu.description
                tvAfterCost.text = decimal.format(menu.price)
                if(menu.discountRate != null) {
                    setSale(menu)
                }
            }

            itemView.setOnClickListener {
                menu.id?.let { key -> listener.itemClickCallback(key) }
            }
        }

        private fun setSale(menu: Menu) {
            with(binding) {
                tvBeforeCost.visibility = View.VISIBLE
                tvBeforeCost.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                tvBeforeCost.text = setSalePrice(menu.discountRate, menu.price).toString()
                setBadge(menu.discountPolicy ?: "none")
            }
        }

        private fun setSalePrice(rate: Int?, price: Int?): Int {
            val discountRate = (rate?.div(100)) ?: 0
            return price?.times(discountRate) ?: 0
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        private fun setBadge(sale: String) {
            when (sale) {
                "런칭특가" -> {
                    with(binding) {
                        tvLaunchingCostBadge.visibility = View.VISIBLE
                        tvLaunchingCostBadge.text = sale
                        tvLaunchingCostBadge.background = root.context.getDrawable(R.drawable.background_badge_event)
                    }
                }
                "이벤트특가" -> {
                    with(binding) {
                        tvLaunchingCostBadge.visibility = View.VISIBLE
                        tvLaunchingCostBadge.text = sale
                        tvLaunchingCostBadge.background = root.context.getDrawable(R.drawable.background_badge_limited)
                        tvLaunchingCostBadge.setTextColor(Color.WHITE)
                    }
                }
                else -> {
                    Log.e("Adapter", "setBadge none")
                }
            }
        }
    }

    inner class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(header: Category) {
            binding.tvMenuListLabel.text = header.category
        }

    }

    object MenuDiffUtil : DiffUtil.ItemCallback<MenuModel>() {

        override fun areItemsTheSame(oldItem: MenuModel, newItem: MenuModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: MenuModel, newItem: MenuModel): Boolean {
            return oldItem == newItem
        }

    }

}