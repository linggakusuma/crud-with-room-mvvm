package com.lingga.quiz.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lingga.quiz.data.local.entities.CollegeStudent

@Dao
interface CollegeStudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(collegeStudent: CollegeStudent)

    @Query("select * from table_college_student")
    fun getUser(): LiveData<CollegeStudent>

    @Query("delete from table_college_student")
    fun clear()

    @Update
    fun updateUser(collegeStudent: CollegeStudent)
}