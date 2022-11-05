package com.amity.testapplication.presentation.todoList


interface IMainNavigator {
    fun updateUIWithToDo()
    fun onOpenError(error: String)
}