package com.lingga.quiz.di.module

import com.lingga.quiz.di.ActivityScoped
import com.lingga.quiz.ui.collegeactivities.CollegeActivitiesActivity
import com.lingga.quiz.ui.home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributeCollegeActivitiesActivity(): CollegeActivitiesActivity

}