package com.lingga.quiz.di.module

import android.app.Application
import androidx.room.Room
import com.lingga.quiz.data.local.room.CollegeStudentDao
import com.lingga.quiz.data.local.room.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application): Database =
        Room.databaseBuilder(application, Database::class.java, "College.db").build()

    @Provides
    @Singleton
    fun provideCollegeStudentDao(database: Database): CollegeStudentDao {
        return database.collegeStudentDao()
    }
}