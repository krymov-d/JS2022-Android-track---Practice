package kz.kd.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val counter = intent.getIntExtra(EXTRA_COUNTER, 0)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = getString(R.string.result_title, counter)
    }
}