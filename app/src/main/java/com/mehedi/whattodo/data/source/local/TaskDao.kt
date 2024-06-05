package com.mehedi.whattodo.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mehedi.whattodo.data.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)
    

    @Query("SELECT * FROM TASK_TABLE")
    fun getAllTask(): LiveData<List<Task>>
    
    
}