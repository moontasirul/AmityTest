package com.amity.testapplication.presentation.todoList

import com.amity.testapplication.data.model.local.ToDoModel
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * To-Do list item view Model class
 * is responsible to manage todoModel data and bind with UI
 */
class ToDoItemViewModel(item: ToDoModel) {
    // item title
    var title = MutableStateFlow(item.title)

    // to-do item status weather it is completed or not
    var status = MutableStateFlow(
        if (item.completed == true) "Completed" else "Not Yet"
    )

    // to-do item status weather it is completed or not
    var taskStatus = MutableStateFlow(item.completed)
}