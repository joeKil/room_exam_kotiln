package com.example.room_exam_kotiln

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Room.databaseBuilder
import com.example.room_exam_kotiln.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 2023.12전 코틀린
        //setContentView(R.layout.activity_main)

        // 2023.12 이후 권장하는 방식
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = databaseBuilder(this, AppDatabase::class.java, "todo-db")
            .allowMainThreadQueries()
            .build()

        // LiveData
        db.todoDao().getAll().observe(this, Observer { todos ->
            binding.resultText.text = todos.toString()
        })


        binding.addButton.setOnClickListener {
            db.todoDao().insert(Todo(binding.todoEdit.text.toString()))
        }
    }
}