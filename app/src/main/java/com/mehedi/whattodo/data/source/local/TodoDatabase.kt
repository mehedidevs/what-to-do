package com.mehedi.whattodo.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mehedi.whattodo.data.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    
    companion object {
        private var database: TodoDatabase? = null
        
        @Synchronized
        fun getInstance(context: Context): TodoDatabase {
            if (database == null) {
                database =
                    Room.databaseBuilder(context, TodoDatabase::class.java, "task_db").build()
                return database as TodoDatabase
            }
            return database as TodoDatabase
        }
        
        
    }
    
}