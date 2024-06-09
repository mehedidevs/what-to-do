package com.mehedi.whattodo.data.source

import androidx.lifecycle.LiveData
import com.mehedi.whattodo.data.Task

interface TasksDataSource {
    suspend fun saveTask(task: Task)

    fun getAllTAsk(): LiveData<List<Task>>

    fun getTaskById(id: Int): LiveData<Task>

}