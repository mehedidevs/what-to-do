package com.mehedi.whattodo.data.source.local

import androidx.lifecycle.LiveData
import com.mehedi.whattodo.data.Task
import com.mehedi.whattodo.data.source.TasksDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(
    private val dao: TaskDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TasksDataSource {
    override suspend fun saveTask(task: Task) {
        withContext(ioDispatcher) {
            dao.insertTask(task)
        }
    }

    override fun getAllTAsk(): LiveData<List<Task>> {
        return dao.getAllTask()

    }

    override fun getTaskById(id: Int): LiveData<Task> {
        return dao.getTaskId(id)
    }


}