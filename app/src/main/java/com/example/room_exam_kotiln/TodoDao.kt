package com.example.room_exam_kotiln

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
abstract class TodoDao {
    @Query("SELECT * FROM Todo")
    abstract fun getAll(): LiveData<List<Todo>>

    @Insert
    abstract fun insert(todo: Todo)

    @Update
    abstract fun update(todo: Todo)

    @Delete
    abstract fun delete(todo: Todo)
}