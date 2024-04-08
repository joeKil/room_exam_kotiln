package com.example.room_exam_kotiln

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Todo(
    var title: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    override fun toString(): String {
        return title
    }
}