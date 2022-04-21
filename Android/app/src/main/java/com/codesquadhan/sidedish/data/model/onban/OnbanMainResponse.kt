package com.codesquadhan.sidedish.data.model.onban

data class OnbanMainResponse(
    val body: List<OnbanBody>,
    val statusCode: Int
)