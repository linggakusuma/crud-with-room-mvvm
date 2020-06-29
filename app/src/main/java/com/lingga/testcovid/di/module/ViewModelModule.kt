package com.lingga.testcovid.di.module

import androidx.lifecycle.ViewModelProvider
import com.lingga.testcovid.utils.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}