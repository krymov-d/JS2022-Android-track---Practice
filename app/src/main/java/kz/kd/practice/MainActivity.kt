package kz.kd.practice

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager


private const val tag = "WorkManager"
private const val TAG = "WorkManager"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvStart: TextView = findViewById(R.id.tv_start)
        val tvCancel: TextView = findViewById(R.id.tv_cancel)

        tvStart.setOnClickListener {
            val myWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
                .addTag(tag)
                .build()

            WorkManager.getInstance(this).enqueue(myWorkRequest)

            WorkManager.getInstance(this).getWorkInfosByTagLiveData(tag)
                .observe(this) { mutableList ->
                    Log.d(TAG, mutableList.toString())
                    mutableList.forEach { workInfo ->
                        Log.d(TAG, "${workInfo.id} ${workInfo.state} ${workInfo.progress}")
                        if (workInfo.tags.findLast { it.equals(tag) }.equals(tag)) {
                            tvStart.text = workInfo.toString()
                        }
                    }
                }
        }

        tvCancel.setOnClickListener {
            WorkManager.getInstance(this).cancelAllWorkByTag(tag)
        }

    }
}