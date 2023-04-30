package kz.kd.practice

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {

    private var preferences: SharedPreferences? = null
    private var listener: SharedPreferences.OnSharedPreferenceChangeListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = PreferenceManager.getDefaultSharedPreferences(this)
        listener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            Log.d("listener", key)
            Toast.makeText(this, sharedPreferences.getString(key, "listener"), Toast.LENGTH_SHORT)
                .show()
        }
        preferences?.registerOnSharedPreferenceChangeListener(listener)

        val tvValue: TextView = findViewById(R.id.tv_value)
        val tvValue2: TextView = findViewById(R.id.tv_value_2)

        preferences?.edit()?.putInt("key", 1)?.apply()
        preferences?.edit()?.putString("key2", null)?.apply()

        tvValue.text = preferences?.getInt("key", 0).toString()
        tvValue.setOnClickListener {
            tvValue2.text = preferences?.getString("key2", "String Parse")
        }

//        preferences?.getString("key", "defValue")
//        preferences?.getBoolean("key", false)
//        preferences?.getFloat("key", 0f)
//        preferences?.getInt("key", 0)
//        preferences?.getStringSet("key", arraySetOf("def", "value"))
    }

    override fun onDestroy() {
        preferences?.unregisterOnSharedPreferenceChangeListener(listener)
        super.onDestroy()
    }
}