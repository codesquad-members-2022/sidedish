package com.codesquadhan.sidedish.data.model.onban

data class OnbanBody(
    val alt: String,
    val badge: List<String>,
    val delivery_type: List<String>,
    val description: String,
    val detail_hash: String,
    val image: String,
    val n_price: String,
    val s_price: String,
    val title: String
)