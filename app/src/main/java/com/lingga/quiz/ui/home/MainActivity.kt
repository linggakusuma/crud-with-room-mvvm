package com.lingga.quiz.ui.home

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.lingga.quiz.R
import com.lingga.quiz.data.base.BaseActivity
import com.lingga.quiz.data.local.entities.CollegeStudent
import com.lingga.quiz.databinding.ActivityMainBinding
import com.lingga.quiz.ui.collegeactivities.CollegeActivitiesActivity
import com.lingga.quiz.ui.collegeactivities.CollegeActivitiesViewModel
import com.lingga.quiz.utils.ext.observe
import com.lingga.quiz.utils.ext.setTransparentStatusBar
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CollegeActivitiesViewModel by viewModels { viewModelFactory }

    private val adapter by lazy { HomeAdapter { navigateToEditActivities(it) } }

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
                layoutManager = GridLayoutManager(context, 1)
            }
        }
    }

    private fun navigateToAddActivities() {
        val intent = Intent(this, CollegeActivitiesActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToEditActivities(collegeStudent: CollegeStudent) {
        val intent = Intent(this, CollegeActivitiesActivity::class.java).apply {
            putExtra(EXTRA_ID, collegeStudent.id)
        }
        startActivity(intent)
    }
}
