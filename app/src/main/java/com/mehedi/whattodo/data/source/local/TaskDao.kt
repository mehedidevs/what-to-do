package com.mehedi.whattodo.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mehedi.whattodo.data.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Query("SELECT * FROM TASK_TABLE")
    fun getAllTask(): LiveData<List<Task>>

    @Query("SELECT * FROM task_table WHERE id= :id")
    fun getTaskId(id: Int): LiveData<Task>?


}