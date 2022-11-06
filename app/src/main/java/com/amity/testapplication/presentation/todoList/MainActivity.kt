package com.amity.testapplication.presentation.todoList

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.amity.testapplication.core.initializer.TimberInitializer
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
        binding.lifecycleOwner = this
        binding.mainViewModel = mainViewModel
        setContentView(binding.root)

        mainViewModel.setNavigator(this)
        // call to do list
        mainViewModel.fetchToDoData()
    }


    /**
     * update UI after getting response
     */
    override fun updateUIWithToDo() {
        toDoListAdapter = ToDoListAdapter()
        if (mainViewModel.toDoResponse.value.isNotEmpty()) {
            toDoListAdapter.addItems(mainViewModel.toDoResponse.value)
            binding.todoRecyclerView.adapter = toDoListAdapter
        } else {
            binding.notDataTv.visibility = View.VISIBLE
        }

    }

    /**
     * error handling from API
     */
    override fun onOpenError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}