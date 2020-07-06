package com.lingga.quiz.data.local.room

import androidx.room.*
import com.lingga.quiz.data.local.entities.CollegeStudent
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface CollegeStudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActivities(collegeStudent: CollegeStudent) : Completable

    @Query("select * from table_college_student")
    fun getActivities(): Flowable<List<CollegeStudent>>

    @Query("delete from table_college_student")
    fun clear()

    @Update
    fun updateUser(collegeStudent: CollegeStudent)
}