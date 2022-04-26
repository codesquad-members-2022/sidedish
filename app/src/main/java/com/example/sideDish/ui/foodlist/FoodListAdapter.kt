package com.example.sideDish.ui.foodlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sideDish.R
import com.example.sideDish.data.model.FoodCategory
import com.example.sideDish.data.model.Item
import com.example.sideDish.databinding.MainSummaryItemBinding
import com.example.sideDish.databinding.SectionBinding

private const val VIEW_TYPE_SECTION = 1
private const val VIEW_TYPE_CONTENT = 2

class FoodListAdapter(private val viewModel: FoodListViewModel) :
    ListAdapter<Item, RecyclerView.ViewHolder>(diffUtil) {
    inner class SectionViewHolder(private val binding: SectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(section: Item.Section) {
            binding.sectionText.text = section.category.sectionTitle
            binding.sectionText.setOnClickListener {
                binding.sectionCountText.visibility = View.VISIBLE
                val count = viewModel.getCategoryItemsCount(section.category)
                binding.sectionCountText.text = String.format("총 %d개의 상품이 등록되어 있습니다.", count)
            }
        }
    }

    inner class SummaryItemViewHolder(private val binding: MainSummaryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodInfo: Item.FoodInfo) = with(binding) {
            binding.foodInfo = foodInfo
            binding.viewmodel = viewModel
//            executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_SECTION -> {
                SectionViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.section,
                        parent,
                        false
                    )
                )
            }
            VIEW_TYPE_CONTENT -> {
                SummaryItemViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.main_summary_item,
                        parent,
                        false
                    )
                )
            }
            else -> error("View Type을 찾을 수 없습니다.")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SectionViewHolder -> {
                holder.bind(getItem(position) as Item.Section)
            }
            is SummaryItemViewHolder -> {
                holder.bind(getItem(position) as Item.FoodInfo)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Item.Section -> VIEW_TYPE_SECTION
            is Item.FoodInfo -> VIEW_TYPE_CONTENT
        }
    }

    fun updateCategoryItems(category: FoodCategory) {
        viewModel.updateItems(category)
    }
}

private val diffUtil = object : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return when (oldItem) {
            is Item.Section -> oldItem == (newItem as? Item.Section) ?: false
            is Item.FoodInfo -> oldItem == (newItem as? Item.FoodInfo) ?: false
        }
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return when (oldItem) {
            is Item.Section -> oldItem.category == (newItem as? Item.Section)?.category ?: false
            is Item.FoodInfo -> oldItem.detailHash == (newItem as? Item.FoodInfo)?.detailHash ?: false
        }
    }
}