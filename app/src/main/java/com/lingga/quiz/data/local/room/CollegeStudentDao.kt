package com.lingga.quiz.data.local.room

import androidx.room.*
import com.lingga.quiz.data.local.entities.CollegeStudent
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface CollegeStudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActivities(collegeStudent: CollegeStudent): Completable

    @Query("SELECT * FROM table_college_student WHERE id =:id")
    fun getActivityById(id: Int): Flowable<CollegeStudent>

    @Query("select * from table_college_student")
    fun getActivities(): Flowable<List<CollegeStudent>>

    @Query("DELETE FROM table_college_student WHERE id = :id")
    fun delete(id: Int): Completable

    @Update
    fun updateActivity(collegeStudent: CollegeStudent): Completable
}