package com.amity.testapplication.presentation.todoList

import com.amity.testapplication.core.base.BaseViewModel
import com.amity.testapplication.domain.userCase.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ToDoRepository) :
    BaseViewModel<IMainNavigator>() {


    private val _isLoading = MutableStateFlow(true)
    val isLoadings = _isLoading.asStateFlow()

}