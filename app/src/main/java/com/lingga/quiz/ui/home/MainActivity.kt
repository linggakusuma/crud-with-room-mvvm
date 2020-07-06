package com.lingga.quiz.ui.home

import com.lingga.quiz.R
import com.lingga.quiz.data.base.BaseActivity
import com.lingga.quiz.databinding.ActivityMainBinding
import com.lingga.quiz.utils.ext.setTransparentStatusBarBlack

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun subscribeUi() {
        super.subscribeUi()
        setTransparentStatusBarBlack()
    }
}
