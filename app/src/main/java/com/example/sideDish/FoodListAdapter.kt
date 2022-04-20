package com.example.sideDish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sideDish.databinding.MainSummaryItemBinding
import com.example.sideDish.databinding.SectionBinding

private const val VIEW_TYPE_SECTION = 1
private const val VIEW_TYPE_CONTENT = 2

class FoodListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<Item>()

    inner class SectionViewHolder(private val binding: SectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(section: Item.Section) {
            binding.sectionText.text = when (section.category) {
                FoodCategory.MAIN -> "모두가 좋아하는\n든든한 메인 요리"
                FoodCategory.SOUP -> "정성이 담긴\n뜨끈뜨근 국물요리"
                FoodCategory.SIDE -> "식탁을 풍성하게 하는\n정갈한 밑반찬"
            }
        }
    }

    inner class SummaryItemViewHolder(private val binding: MainSummaryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodInfo: Item.FoodInfo) = with(binding) {
            binding.foodInfo = foodInfo
            executePendingBindings()
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
            else -> throw Exception("View Type을 찾을 수 없습니다.")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SectionViewHolder -> {
                holder.bind(items[position] as Item.Section)
            }
            is SummaryItemViewHolder -> {
                holder.bind(items[position] as Item.FoodInfo)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Item.Section -> VIEW_TYPE_SECTION
            is Item.FoodInfo -> VIEW_TYPE_CONTENT
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(category: FoodCategory, newItems: List<Item>) {
        var sectionIndex = -1
        items.forEachIndexed { itemIndex, item ->
            when (item) {
                is Item.Section -> {
                    if (item.category == category) {
                        sectionIndex = itemIndex
                        return@forEachIndexed
                    }
                }
                else -> {}
            }
        }
        if (sectionIndex == -1) {
            items.addAll(newItems)

            notifyItemRangeChanged(items.size + 1, newItems.size)
        } else {
            var removedIndex = 0
            for (index in sectionIndex + 1 until items.size) {
                when (items[index]) {
                    is Item.Section -> break
                    else -> removedIndex++
                }
            }

            items.removeAll(items.slice(sectionIndex + 1..sectionIndex + removedIndex))
            items.addAll(sectionIndex + 1, newItems)

            notifyItemRangeRemoved(sectionIndex + 1, removedIndex)
            notifyItemRangeChanged(sectionIndex + 1, newItems.size)
        }
    }
}
