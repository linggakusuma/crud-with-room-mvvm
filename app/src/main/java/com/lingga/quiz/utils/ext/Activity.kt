package com.lingga.quiz.utils.ext

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View

fun Activity.setTransparentStatusBarBlack() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        var flags = window.decorView.systemUiVisibility
        flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR // for set light status bar
        window.decorView.systemUiVisibility = flags
        window.statusBarColor = Color.TRANSPARENT
    }
}