package kz.kd.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val counter = intent.getIntExtra(EXTRA_COUNTER, 0)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = getString(R.string.result_title, counter)

        val resetButton = findViewById<Button>(R.id.resetButton)
        resetButton.setOnClickListener {
            resultTextView.text = getString(R.string.result_title, 0)
            setResult(Activity.RESULT_OK, Intent().putExtra(EXTRA_IS_RESET, true))
        }

//        val user: User = intent.getSerializableExtra(EXTRA_USER, User::class.java) as User
//        val user2: User2 = intent.getParcelableExtra(EXTRA_USER_2, User2::class.java) as User2
    }
}