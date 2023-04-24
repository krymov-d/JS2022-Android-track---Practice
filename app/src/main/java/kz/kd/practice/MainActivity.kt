package kz.kd.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_COUNTER = "EXTRA_COUNTER"
const val EXTRA_IS_RESET = "EXTRA_IS_RESET"
const val EXTRA_USER = "EXTRA_USER"
const val EXTRA_USER_2 = "EXTRA_USER_2"
private const val KEY_COUNTER = "KEY_COUNTER"

class MainActivity : AppCompatActivity() {

    private lateinit var resultActivityResult: ActivityResultLauncher<Intent>
    private lateinit var counterTextView: TextView
    private lateinit var user: User
    private lateinit var user2: User2
    private var currentCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = User(name = "Random", age = 0, isMale = true, height = 180.0)
        user2 = User2(name = "Random", age = 0, isMale = true, height = 180.0)

        savedInstanceState?.getInt(KEY_COUNTER)?.let { counter ->
            currentCounter = counter
        }

        val plusButton: Button = findViewById(R.id.plusButton)
        counterTextView = findViewById(R.id.counterTextView)

        counterTextView.text = currentCounter.toString()

        plusButton.setOnClickListener {
            currentCounter++
            counterTextView.text = currentCounter.toString()
        }

        resultActivityResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "result is achieved", Toast.LENGTH_SHORT).show()
                    val isReset = it.data?.getBooleanExtra(EXTRA_IS_RESET, false) ?: false
                    if (isReset) {
                        currentCounter = 0
                        counterTextView.text = currentCounter.toString()
                    }
                }
            }

        val resultButton: Button = findViewById(R.id.resultButton)
        resultButton.setOnClickListener {
            Intent(this, ResultActivity::class.java).apply {
                putExtra(EXTRA_COUNTER, currentCounter)
                putExtra(EXTRA_USER, user)
                putExtra(EXTRA_USER_2, user2)
                resultActivityResult.launch(this)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, currentCounter)
    }
}