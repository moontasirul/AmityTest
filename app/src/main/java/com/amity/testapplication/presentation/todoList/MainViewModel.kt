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
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
open class MainViewModel @Inject constructor(private val getTodoUseCase: GetTodoUseCase) :
    ViewModel() {

    /**
     * invoke navigator
     */
    private lateinit var mNavigator: IMainNavigator

    /**
     * invoke To-Do list
     */
    var toDoResponse = MutableStateFlow(listOf<ToDoModel>())


    /**
     * Get Navigator
     */
    private val navigator: IMainNavigator
        get() {
            return mNavigator
        }

    /**
     * Set Navigator
     */
    fun setNavigator(navigator: IMainNavigator) {
        this.mNavigator = navigator
    }

    /**
     * invoke loader when data fetch
     */
    private val _isLoading = MutableStateFlow(true)
    val isLoadings = _isLoading.asStateFlow()


    /**
     * try to fetch to do list data and update UI
     */
    fun fetchToDoData() {
        viewModelScope.launch {
            getTodoUseCase().collectLatest { response ->
                when (response) {
                    is Resource.Success -> {
                        _isLoading.value = false
                        response.data?.let {
                            toDoResponse.value = it
                            navigator.updateUIWithToDo()
                        }
                    }
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                        response.error?.localizedMessage?.let { navigator.onOpenError(it) }
                    }
                }
            }
        }
    }

}