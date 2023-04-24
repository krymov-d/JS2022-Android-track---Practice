package kz.kd.practice

import android.content.SharedPreferences
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val color1: Int = ContextCompat.getColor(this, R.color.black)
        val color2 = ResourcesCompat.getColor(resources, R.color.black, null)
        val text: String = getString(R.string.app_name)
        val dimen: Float = resources.getDimension(androidx.core.R.dimen.compat_notification_large_icon_max_width)
        val apps: MutableList<ApplicationInfo> = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        val prefs: SharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE)
    }
}