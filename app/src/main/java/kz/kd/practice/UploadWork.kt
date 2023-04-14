package kz.kd.practice

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

private const val TAG = "WorkManager"

class UploadWork(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val imageUriInput =
            inputData.getString("IMAGE_URI") ?: return Result.failure()

        Log.d(TAG, imageUriInput)
        //uploadFile(imageUriInput)
        return Result.success()
    }
}