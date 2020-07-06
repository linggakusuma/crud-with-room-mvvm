package com.lingga.quiz.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_college_student")
data class CollegeStudent(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val lecturer:String?,
    val courses: String?,
    val date: String?,
    val note: String
)