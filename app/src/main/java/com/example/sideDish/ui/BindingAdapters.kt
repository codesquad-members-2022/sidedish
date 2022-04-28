package com.example.sideDish.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.sideDish.R
import com.example.sideDish.data.model.Item

@BindingAdapter("image")
fun setImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
}

@BindingAdapter("show_count")
fun setShowCount(view: TextView, section: Item.Section?) {
    section?.let {
        view.text =
            String.format(view.context.getString(R.string.header_items_count), it.count)
    }
}
