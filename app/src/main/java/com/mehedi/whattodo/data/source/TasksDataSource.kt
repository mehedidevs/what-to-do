package com.mehedi.whattodo.data.source

import com.mehedi.whattodo.data.Task

interface TasksDataSource {
    suspend fun saveTask(task: Task)
    
}