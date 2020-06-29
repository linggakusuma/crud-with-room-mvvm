package com.lingga.testcovid.data.base

import com.lingga.testcovid.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent.inject(this)
        return appComponent
    }
}