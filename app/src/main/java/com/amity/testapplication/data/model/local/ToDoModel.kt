package com.amity.testapplication.data.model.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.amity.testapplication.data.model.remote.ToDoListResponseItem
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "todo_model")
data class ToDoModel(
    @PrimaryKey
    val completed: Boolean?,
    val id: Int?,
    val title: String?,
    val userId: Int?
) : Parcelable


fun ToDoListResponseItem.toDoModel(): ToDoModel {
    return ToDoModel(
        id = id,
        title = title.toString(),
        completed = completed,
        userId = userId
    )
}