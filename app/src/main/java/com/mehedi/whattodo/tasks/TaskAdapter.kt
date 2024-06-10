package com.mehedi.whattodo.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.whattodo.data.Task
import com.mehedi.whattodo.databinding.TaskItemBinding

class TaskAdapter(
    private val viewmodel: TaskViewmodel, private val taskClickListener: TaskClickListener
) : ListAdapter<Task, TaskAdapter.TaskViewHolder>(COMARATOR) {
    fun interface TaskClickListener {
        fun onTaskClicked(task: Task)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {

        return TaskViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(viewmodel, task, taskClickListener)

    }

    class TaskViewHolder private constructor(private val binding: TaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewmodel: TaskViewmodel, mTask: Task, taskClickListener: TaskClickListener) {

            binding.apply {
                root.setOnClickListener {
                    taskClickListener.onTaskClicked(mTask)
                }
                taskViewModel = viewmodel
                task = mTask
                executePendingBindings()
            }

        }

        companion object {
            fun from(parent: ViewGroup): TaskViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return TaskViewHolder(binding)

            }


        }


    }


    companion object {
        val COMARATOR = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.id == newItem.id
            }
        }


    }


}