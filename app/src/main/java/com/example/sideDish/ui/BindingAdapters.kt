package com.example.sideDish.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.sideDish.ui.productdetail.FoodDetailViewModel

@BindingAdapter("image")
fun setImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
}

@BindingAdapter("count")
fun setCount(view: Stepper, count: Int) {
    view.count = count
}

@BindingAdapter("viewModel")
fun setViewModel(view: Stepper, viewModel: FoodDetailViewModel) {
    view.viewModel = viewModel
}
