package com.lingga.quiz.di.module

import androidx.lifecycle.ViewModelProvider
import com.lingga.quiz.utils.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}