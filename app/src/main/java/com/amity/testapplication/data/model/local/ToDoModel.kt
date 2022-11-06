package com.amity.testapplication.data.model.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.amity.testapplication.data.model.remote.ToDoListResponseItem
import kotlinx.parcelize.Parcelize

/**
 * local to do model class
 */
@Parcelize
@Entity(tableName = "todo_model")
data class ToDoModel(
    @PrimaryKey
    val id: Int?,
    val completed: Boolean?,
    val title: String?,
    val userId: Int?
) : Parcelable


/**
 * Extension function from Remote item
 * return to local todoModel
 */
fun ToDoListResponseItem.toDoModel(): ToDoModel {
    return ToDoModel(
        id = id,
        title = title.toString(),
        completed = completed,
        userId = userId
    )
}