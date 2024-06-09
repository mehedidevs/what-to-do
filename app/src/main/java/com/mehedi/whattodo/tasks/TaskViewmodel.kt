package com.mehedi.whattodo.tasks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mehedi.whattodo.data.source.DefaultTaskRepository

class TaskViewmodel(application: Application) : AndroidViewModel(application) {
    
    private val repository: DefaultTaskRepository = DefaultTaskRepository.getInstance(application)
    
    val getAllTask = repository.getAllTask()

    private val _openTaskEvent = MutableLiveData<Int>()
    val openTaskEvent: LiveData<Int>
        get() = _openTaskEvent

    fun openTask(id: Int) {
        _openTaskEvent.postValue(id)
    }
    
}