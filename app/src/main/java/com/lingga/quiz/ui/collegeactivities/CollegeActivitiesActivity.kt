package com.lingga.quiz.ui.collegeactivities

import android.app.DatePickerDialog
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.lingga.quiz.R
import com.lingga.quiz.data.base.BaseActivity
import com.lingga.quiz.data.local.entities.CollegeStudent
import com.lingga.quiz.databinding.ActivityCollegeActivitiesBinding
import com.lingga.quiz.ui.home.MainActivity
import com.lingga.quiz.utils.ext.observe
import java.util.*
import javax.inject.Inject

class CollegeActivitiesActivity :
    BaseActivity<ActivityCollegeActivitiesBinding>(R.layout.activity_college_activities),
    DatePickerDialog.OnDateSetListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CollegeActivitiesViewModel by viewModels { viewModelFactory }

    override fun initBinding() {
        super.initBinding()
        binding.apply {
            backButton.setOnClickListener { onBackPressed() }
            inputDate.setOnClickListener { showDatePicker() }
            buttonSave.setOnClickListener { onSave() }
            setSupportActionBar(toolbar)
        }
    }

    override fun subscribeUi() {
        super.subscribeUi()
        viewModel.doGetActivity(intent.getIntExtra(MainActivity.EXTRA_ID, 0))
        binding.apply {
            observe(viewModel.collegeStudent) {
                inputCourses.setText(it.courses)
                inputLecturer.setText(it.lecturer)
                inputDate.text = it.date
                inputNotes.setText(it.note)
            }
        }
    }

    private fun showDatePicker() {
        val c = Calendar.getInstance()
        c[Calendar.YEAR] = 2020
        val year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]
        val dpd = DatePickerDialog(this, this, year, month, day)
        dpd.show()
    }

    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val date = "" + String.format("%02d", dayOfMonth) + "-" + String.format(
            "%02d",
            month + 1
        ) + "-" + year
        binding.inputDate.text = date
    }

    private fun onSave() {
        binding.apply {
            val collegeStudent = CollegeStudent(
                lecturer = inputLecturer.text.toString(),
                courses = inputCourses.text.toString(),
                date = inputDate.text.toString(),
                note = inputNotes.text.toString()
            )

            if (intent.getIntExtra(MainActivity.EXTRA_ID, 0) == 0) {
                viewModel.doInsert(collegeStudent)
            } else {
                viewModel.doUpdate(
                    CollegeStudent(
                        id = intent.getIntExtra(MainActivity.EXTRA_ID, 0),
                        lecturer = inputLecturer.text.toString(),
                        courses = inputCourses.text.toString(),
                        date = inputDate.text.toString(),
                        note = inputNotes.text.toString()
                    )
                )
            }
        }
        navigateToHome()
    }

    private fun doDelete() {
        viewModel.doDelete(intent.getIntExtra(MainActivity.EXTRA_ID, 0))
        navigateToHome()
    }

    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val item = menu?.findItem(R.id.delete)
        item?.isVisible = intent.getIntExtra(MainActivity.EXTRA_ID, 0) != 0
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete -> {
                doDelete()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
