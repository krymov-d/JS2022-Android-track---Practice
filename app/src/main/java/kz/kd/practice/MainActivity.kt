package kz.kd.practice

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val ONBOARD_SHOWN_KEY = "key_onboard_show"

class MainActivity : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences
    private lateinit var listener: OnSharedPreferenceChangeListener

    private lateinit var tvValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvValue = findViewById(R.id.tv_value)

        preferences = getSharedPreferences(BuildConfig.APPLICATION_ID, MODE_PRIVATE)
        onSharedPreferencesUpdated(preferences)

        listener =
            OnSharedPreferenceChangeListener { sharedPreferences, _ ->
                onSharedPreferencesUpdated(sharedPreferences)
            }

        preferences.registerOnSharedPreferenceChangeListener(listener)

        val tvValue2: TextView = findViewById(R.id.tv_value_2)
        tvValue2.setOnClickListener {
            preferences
                .edit()
                .putBoolean(ONBOARD_SHOWN_KEY, true)
                .apply()
        }
    }

    private fun onSharedPreferencesUpdated(sharedPreferences: SharedPreferences) {
        val isOnboardShown = sharedPreferences.getBoolean(ONBOARD_SHOWN_KEY, false)
        tvValue.text = if (isOnboardShown) {
            "Hello User"
        } else {
            "Hello Stranger"
        }
    }
}