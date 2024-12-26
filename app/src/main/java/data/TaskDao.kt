package com.example.lastof2024

import androidx.lifecycle.LiveData
import androidx.room.*
import data.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks WHERE isCompleted = :isCompleted")
    fun getTasks(isCompleted: Boolean): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)
}
