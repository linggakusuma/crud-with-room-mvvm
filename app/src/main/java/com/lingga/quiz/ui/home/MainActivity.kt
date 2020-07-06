package com.lingga.quiz.ui.home

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lingga.quiz.R
import com.lingga.quiz.data.base.BaseActivity
import com.lingga.quiz.databinding.ActivityMainBinding
import com.lingga.quiz.ui.collegeactivities.CollegeActivitiesActivity
import com.lingga.quiz.ui.collegeactivities.CollegeActivitiesViewModel
import com.lingga.quiz.utils.ext.observe
import com.lingga.quiz.utils.ext.setTransparentStatusBar
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CollegeActivitiesViewModel by viewModels { viewModelFactory }

    private val adapter by lazy { HomeAdapter() }

    override fun subscribeUi() {
        super.subscribeUi()
        setTransparentStatusBar()
        viewModel.doGetAllActivities()
        observe(viewModel.collegeStudents) {
            adapter.setCollegeStudents(it)
        }
    }

    override fun initBinding() {
        super.initBinding()
        binding.apply {
            buttonAdd.setOnClickListener { navigateToAddActivities() }
            recyclerViewActivities.apply {
                adapter = this@MainActivity.adapter
                layoutManager = GridLayoutManager(context,1)
            }
        }
    }

    private fun navigateToAddActivities() {
        val intent = Intent(this, CollegeActivitiesActivity::class.java)
        startActivity(intent)
    }
}
