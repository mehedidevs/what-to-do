package com.mehedi.whattodo.tasks

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.whattodo.data.Task

@BindingAdapter("app:items")
fun setItems(recyclerview: RecyclerView, items: List<Task>?) {
    items?.let {
        (recyclerview.adapter as TaskAdapter).submitList(it)
    }
    
    
}

