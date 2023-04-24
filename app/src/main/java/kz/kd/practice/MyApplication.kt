package kz.kd.practice

import android.app.Application
import android.util.Log

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.d("MyApplication2", "onCreate() is called")
    }
}