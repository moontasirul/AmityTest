package com.amity.testapplication.presentation.todoList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amity.testapplication.core.network.Resource
import com.amity.testapplication.data.model.local.ToDoModel
import com.amity.testapplication.domain.userCase.GetTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class MainViewModel @Inject constructor(private val getTodoUseCase: GetTodoUseCase) :
    ViewModel() {
    private lateinit var mNavigator: IMainNavigator

    /**
     * Get Navigator
     */
    protected val navigator: IMainNavigator
        get() {
            return mNavigator
        }

    /**
     * Set Navigator
     */
    fun setNavigator(navigator: IMainNavigator) {
        this.mNavigator = navigator
    }

    private val _isLoading = MutableStateFlow(true)
    val isLoadings = _isLoading.asStateFlow()

    var toDoResponse = MutableStateFlow(listOf<ToDoModel>())

    fun getData() {
        viewModelScope.launch {
            getTodoUseCase().collectLatest { response ->
                when (response) {
                    is Resource.Success -> {
                        _isLoading.value = false
                        val todoList = response.data
                        if (todoList != null) {
                            toDoResponse.value = todoList
                            navigator.updateUIWithToDo()
                        }
                    }
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                        val errorMessage = response.error?.localizedMessage

                    }
                }
            }
        }
    }

}