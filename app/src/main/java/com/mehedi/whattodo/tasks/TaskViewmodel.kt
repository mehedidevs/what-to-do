package com.mehedi.whattodo.tasks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mehedi.whattodo.data.source.DefaultTaskRepository

class TaskViewmodel(application: Application) : AndroidViewModel(application) {
    
    private val repository: DefaultTaskRepository = DefaultTaskRepository.getInstance(application)
    
    val getAllTask = repository.getAllTask()
    
    
}