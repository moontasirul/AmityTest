package com.amity.testapplication.presentation.todoList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amity.testapplication.data.model.local.ToDoModel
import com.amity.testapplication.databinding.LayoutItemTodoBinding
import java.util.ArrayList

class ToDoListAdapter : RecyclerView.Adapter<ToDoListAdapter.ToDoItemViewHolder>() {

    private var toDoList: ArrayList<ToDoModel> = arrayListOf()

    inner class ToDoItemViewHolder(binding: LayoutItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val mBinding: LayoutItemTodoBinding = binding
        private lateinit var mItemViewModel: ToDoItemViewModel

        fun onBind(position: Int) {
            val mToDoItem: ToDoModel = toDoList[position]
            mItemViewModel = ToDoItemViewModel(mToDoItem)

            mBinding.toDoViewModel = mItemViewModel
            mBinding.executePendingBindings()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoItemViewHolder {
        val binding: LayoutItemTodoBinding = LayoutItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ToDoItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoItemViewHolder, position: Int) {
        holder.onBind(position)
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addItems(toDos: List<ToDoModel>) {
        toDoList.clear()
        toDoList.addAll(toDos)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return toDoList.size
    }
}