package kz.kd.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

const val EXTRA_COUNTER = "EXTRA_COUNTER"
private const val KEY_COUNTER = "KEY_COUNTER"

class MainActivity : AppCompatActivity() {

    private var currentCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.getInt(KEY_COUNTER)?.let { counter ->
            currentCounter = counter
        }

        val plusButton: Button = findViewById(R.id.plusButton)
        val counterTextView: TextView = findViewById(R.id.counterTextView)

        counterTextView.text = currentCounter.toString()

        plusButton.setOnClickListener {
            currentCounter++
            counterTextView.text = currentCounter.toString()
        }

        val resultButton: Button = findViewById(R.id.resultButton)
        resultButton.setOnClickListener {
            Intent(this, ResultActivity::class.java).apply {
                putExtra(EXTRA_COUNTER, currentCounter)
                startActivity(this)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d("MainActivity", "onSaveInstanceState() is called")

        outState.putInt(KEY_COUNTER, currentCounter)
    }
}