package com.amity.testapplication.presentation.todoList


interface IMainNavigator {
    /**
     * notify UI with response message
     */
    fun updateUIWithToDo()

    /**
     * handle error message
     */
    fun onOpenError(error: String)
}