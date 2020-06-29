package com.lingga.testcovid.di.module

import com.lingga.testcovid.di.ActivityScoped
import com.lingga.testcovid.ui.home.MainActivity
import com.lingga.testcovid.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity
}