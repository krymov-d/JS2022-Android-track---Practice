package kz.kd.practice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val KEY_COUNTER = "Key"

class MainActivity : AppCompatActivity() {

    private var currentCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate() is called")

        savedInstanceState?.getInt(KEY_COUNTER)?.let {
            currentCounter = it
        }

        val plusButton: Button = findViewById(R.id.plusButton)
        val counterTextView: TextView = findViewById(R.id.counterTextView)

        counterTextView.text = currentCounter.toString()

        plusButton.setOnClickListener {
            currentCounter++
            counterTextView.text = currentCounter.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy() is called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "onSaveInstanceState() is called")

        outState.putInt(KEY_COUNTER, currentCounter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("MainActivity", "onRestoreInstanceState() is called")

        currentCounter = savedInstanceState.getInt(KEY_COUNTER)
    }
}