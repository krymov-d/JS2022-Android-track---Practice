package kz.kd.practice

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

private const val TAG = "WorkManager"

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        Log.d(TAG, "doWork: start")

        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            Log.d(TAG, "doWork: cancel")
            e.printStackTrace()
            return Result.failure()
        }

        return Result.success()
    }
}