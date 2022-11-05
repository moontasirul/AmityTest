package com.amity.testapplication.presentation.todoList

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.amity.testapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), IMainNavigator {

    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    lateinit var toDoListAdapter: ToDoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.setNavigator(this)
        mainViewModel.getData()
    }


    override fun updateUIWithToDo() {
        toDoListAdapter = ToDoListAdapter()
        toDoListAdapter.addItems(mainViewModel.toDoResponse.value)
        binding.todoRecyclerView.adapter = toDoListAdapter
    }

    override fun onOpenError(error: String) {

    }
}