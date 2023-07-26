package com.plcoding.cleanarchitecturenoteapp.feature_note

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//step:9 create a class for di and need to register this class in menifest

@HiltAndroidApp
class NoteApp :Application()
