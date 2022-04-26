package com.example.sidedish.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sidedish.R
import com.example.sidedish.data.Menu
import com.example.sidedish.data.Header
import com.example.sidedish.databinding.ItemHeaderBinding
import com.example.sidedish.databinding.ItemMenuListBinding
import com.example.sidedish.ui.MenuItemClickListener
import java.lang.NullPointerException
import java.text.DecimalFormat

private const val HEADER = 0
private const val ITEM = 1

class MenuListAdapter(private val header: Header, private val listener: MenuItemClickListener) :
    ListAdapter<Menu, RecyclerView.ViewHolder>(DiffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> MenuListHeaderViewHolder(
                ItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> MenuListViewHolder(
                ItemMenuListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MenuListHeaderViewHolder -> {
                holder.bind(header)
            }

            is MenuListViewHolder -> {
                holder.bind(getItem(position-1))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> HEADER
            else -> ITEM
        }
    }

    override fun getItemCount(): Int {
        return currentList.size + 1
    }

    object DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Menu>() {

        override fun areItemsTheSame(oldItem: Menu, newItem: Menu): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Menu, newItem: Menu): Boolean {
            return oldItem == newItem
        }

    }

    class MenuListHeaderViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(header: Header) {
            when (header) {
                Header.MAIN -> binding.tvMenuListLabel.text =
                    binding.root.context.getString(R.string.main_header)
                Header.SOUP -> binding.tvMenuListLabel.text =
                    binding.root.context.getString(R.string.soup_header)
                Header.SIDE -> binding.tvMenuListLabel.text =
                    binding.root.context.getString(R.string.side_header)
            }
        }

    }

    inner class MenuListViewHolder(private val binding: ItemMenuListBinding) :
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
//                menu.id?.let { key -> listener.itemClickCallback(key) }
            }
        }

        private fun setSale(menu: Menu) {
            with(binding) {
                tvBeforeCost.visibility = View.VISIBLE
                tvBeforeCost.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                tvBeforeCost.text = setSalePrice(menu.discountRate, menu.price).toString()
                setBadge(menu.discountPoilcy ?: "none")
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
//                    binding.tvLimitedCostBadge.visibility = View.VISIBLE
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

}