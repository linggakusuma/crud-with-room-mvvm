package com.lingga.quiz.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lingga.quiz.data.local.entities.CollegeStudent

@Database(
    entities = [
        CollegeStudent::class
    ], version = 2
)
abstract class Database : RoomDatabase() {
    abstract fun collegeStudentDao(): CollegeStudentDao
}