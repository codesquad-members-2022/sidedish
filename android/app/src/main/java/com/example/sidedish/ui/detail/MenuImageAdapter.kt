package com.example.sidedish.ui.detail

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun applyImageAdapter(view: ImageView, imageUrl: String?) {
    if (imageUrl != null) {
        Glide.with(view).load(imageUrl).into(view)
    } else {
        Glide.with(view)
            .load("https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg")
            .into(view)
    }
}