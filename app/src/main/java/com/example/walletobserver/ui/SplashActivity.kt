package com.example.walletobserver.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.walletobserver.ui.intro.IntroActivity
import com.example.walletobserver.util.PrefsManager
import com.example.walletobserver.util.extensions.launchActivity
import org.koin.core.KoinComponent
import org.koin.core.inject

class SplashActivity : AppCompatActivity(), KoinComponent {

  private val prefs: PrefsManager by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onResume() {
    super.onResume()
    if (!prefs.isItFirstTimeLaunch()) {
      this.launchActivity<MainActivity> { }
    } else {
      this.launchActivity<IntroActivity> { }
    }
    finish()
  }
}