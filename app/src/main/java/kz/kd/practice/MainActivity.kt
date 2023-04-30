package kz.kd.practice

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val ONBOARD_SHOWN_KEY = "key_onboard_show"

class MainActivity : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = getSharedPreferences(BuildConfig.APPLICATION_ID, MODE_PRIVATE)
        val isOnboardShown = preferences.getBoolean(ONBOARD_SHOWN_KEY, false)

        val tvValue: TextView = findViewById(R.id.tv_value)
        tvValue.text = if (isOnboardShown) {
            "Hello User"
        } else {
            "Hello Stranger"
        }

        val tvValue2: TextView = findViewById(R.id.tv_value_2)
        tvValue2.setOnClickListener {
            preferences
                .edit()
                .putBoolean(ONBOARD_SHOWN_KEY, true)
                .apply()
        }
    }
}