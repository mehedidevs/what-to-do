package com.mehedi.whattodo.addtask

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mehedi.whattodo.R
import com.mehedi.whattodo.data.Task
import com.mehedi.whattodo.data.source.DefaultTaskRepository
import com.mehedi.whattodo.utils.toTimedString
import kotlinx.coroutines.launch

class AddTaskViewModel(private val application: Application) : AndroidViewModel(application) {
    
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    private val repository: DefaultTaskRepository = DefaultTaskRepository.getInstance(application)
    
    private val _snackbarMsg = MutableLiveData<Int>()
    val snackbarMsg: LiveData<Int>
        get() = _snackbarMsg
    
    private val titleLength = 6
    
    
    fun saveTask() {
        val currentTitle = title.value
        val currentDescription = description.value
        
        val task =
            Task(
                title = currentTitle.toTimedString(),
                description = currentDescription.toTimedString()
            )
        
        if (isValidTask(task)) {
            createTask(task)
        }
    }
    
    private fun isValidTask(task: Task): Boolean {
        
        if (task.title.isNullOrEmpty() || task.description.isNullOrEmpty()) {
            _snackbarMsg.postValue(R.string.empty_task_message)
            return false
        }
        
        if (task.title.toString().length < titleLength) {
            _snackbarMsg.postValue(R.string.title_must_be_6_char_or_more)
            return false
        }
        
        return true
        
    }
    
    private fun createTask(task: Task) {
        viewModelScope.launch {
            repository.saveTask(task)
        }
        
    }
    
    
}