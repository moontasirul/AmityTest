package com.amity.testapplication.data.model.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ToDoListResponseItem(
    @Json(name = "completed")
    val completed: Boolean?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "userId")
    val userId: Int?
)