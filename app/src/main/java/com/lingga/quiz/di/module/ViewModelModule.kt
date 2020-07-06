package com.lingga.quiz.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lingga.quiz.di.ViewModelKey
import com.lingga.quiz.ui.collegeactivities.CollegeActivitiesViewModel
import com.lingga.quiz.utils.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CollegeActivitiesViewModel::class)
    internal abstract fun loginViewModel(viewModel: CollegeActivitiesViewModel): ViewModel
}