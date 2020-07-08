package com.lingga.quiz.ui.collegeactivities

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lingga.quiz.data.base.BaseViewModel
import com.lingga.quiz.data.local.entities.CollegeStudent
import com.lingga.quiz.data.local.room.Database
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CollegeActivitiesViewModel @Inject constructor(private val database: Database) :
    BaseViewModel() {

    private val _collegeStudents = MutableLiveData<List<CollegeStudent>>()
    val collegeStudents: LiveData<List<CollegeStudent>> = _collegeStudents

    private val _collegeStudent = MutableLiveData<CollegeStudent>()
    val collegeStudent: LiveData<CollegeStudent> = _collegeStudent

    private fun insertActivities(collegeStudent: CollegeStudent): Completable {
        return database.collegeStudentDao().insertActivities(collegeStudent)
    }

    private fun getAllActivities(): Flowable<List<CollegeStudent>> {
        return database.collegeStudentDao().getActivities()
    }

    private fun getActivity(id: Int): Flowable<CollegeStudent> {
        return database.collegeStudentDao().getActivityById(id)
    }

    private fun updateActivity(collegeStudent: CollegeStudent): Completable {
        return database.collegeStudentDao().updateActivity(collegeStudent)
    }

    private fun deleteActivity(id:Int): Completable {
        return database.collegeStudentDao().delete(id)
    }

    fun doInsert(collegeStudent: CollegeStudent) {
        compositeDisposable.add(
            insertActivities(collegeStudent).subscribeOn(Schedulers.io())
                .doOnSubscribe { setLoading() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { finishLoading() },
                    { throwable ->
                        Log.e(TAG, "Unable insert", throwable)
                        finishLoading()
                    }
                )
        )
    }

    fun doGetAllActivities() {
        compositeDisposable.add(
            getAllActivities().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { activities -> _collegeStudents.postValue(activities) },
                    { throwable -> Log.e(TAG, "Unable to get programs", throwable) }
                )
        )
    }

    fun doGetActivity(id: Int) {
        compositeDisposable.add(
            getActivity(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { activities -> _collegeStudent.postValue(activities) },
                    { throwable -> Log.e(TAG, "Unable to get programs", throwable) }
                )
        )
    }

    fun doUpdate(collegeStudent: CollegeStudent) {
        compositeDisposable.add(
            updateActivity(collegeStudent).subscribeOn(Schedulers.io())
                .doOnSubscribe { setLoading() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { finishLoading() },
                    { throwable ->
                        Log.e(TAG, "Unable to update", throwable)
                        finishLoading()
                    }
                )
        )
    }

    fun doDelete(id:Int) {
        compositeDisposable.add(
            deleteActivity(id).subscribeOn(Schedulers.io())
                .doOnSubscribe { setLoading() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { finishLoading() },
                    { throwable ->
                        Log.e(TAG, "Unable to delete", throwable)
                        finishLoading()
                    }
                )
        )
    }
}