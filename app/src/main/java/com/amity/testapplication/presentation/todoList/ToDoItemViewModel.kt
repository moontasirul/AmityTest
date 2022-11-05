package com.amity.testapplication.presentation.todoList

import com.amity.testapplication.data.model.local.ToDoModel
import kotlinx.coroutines.flow.MutableStateFlow

class ToDoItemViewModel(item: ToDoModel) {
    var title = MutableStateFlow(item.title)
    var status = MutableStateFlow(item.completed)
}