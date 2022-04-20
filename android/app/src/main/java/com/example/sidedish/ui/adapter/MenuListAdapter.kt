package com.example.sidedish.ui.adapter

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sidedish.R
import com.example.sidedish.data.Body
import com.example.sidedish.data.Header
import com.example.sidedish.databinding.ItemHeaderBinding
import com.example.sidedish.databinding.ItemMenuListBinding

private const val HEADER = 0
private const val ITEM = 1

class MenuListAdapter(private val header: Header): ListAdapter<Body, RecyclerView.ViewHolder>(DiffUtil) {

    lateinit var itemClickCallback: ((key: String) -> Unit)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val listBinding = ItemMenuListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val headerBinding = ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return when(viewType) {
            HEADER -> MenuListHeaderViewHolder(headerBinding)
            else -> MenuListViewHolder(listBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MenuListHeaderViewHolder -> {
                holder.bind(header)
            }

            is MenuListViewHolder -> {
                holder.bind(getItem(position))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> HEADER
            else -> ITEM
        }
    }

    object DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Body>() {

        override fun areItemsTheSame(oldItem: Body, newItem: Body): Boolean {
            return oldItem.detailHash == newItem.detailHash
        }

        override fun areContentsTheSame(oldItem: Body, newItem: Body): Boolean {
            return oldItem == newItem
        }

    }

    class MenuListHeaderViewHolder(private val binding: ItemHeaderBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(header: Header) {
            when(header) {
                Header.MAIN -> binding.tvMenuListLabel.text = binding.root.context.getString(R.string.main_header)
                Header.SOUP -> binding.tvMenuListLabel.text = binding.root.context.getString(R.string.soup_header)
                Header.SIDE -> binding.tvMenuListLabel.text = binding.root.context.getString(R.string.side_header)
            }
        }

    }

    inner class MenuListViewHolder(private val binding: ItemMenuListBinding): RecyclerView.ViewHolder(binding.root) {

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