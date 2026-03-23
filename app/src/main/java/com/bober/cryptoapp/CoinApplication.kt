package com.bober.cryptoapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// @HiltAndroidApp triggers Hilt's code generation.
// Without this, dependency injection won't work
@HiltAndroidApp
class CoinApplication : Application()