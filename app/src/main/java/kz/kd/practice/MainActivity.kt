package kz.kd.practice

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

class MainActivity : AppCompatActivity() {

    private lateinit var btnDatePicker: Button
    private lateinit var btnTimePicker: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initClickListeners()
    }

    private fun initViews() {
        btnDatePicker = findViewById(R.id.btn_date_picker)
        btnTimePicker = findViewById(R.id.btn_time_picker)
    }

    private fun initClickListeners() {
        btnDatePicker.setOnClickListener {
            val onDateSetListener =
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    Toast.makeText(this, "You picked $dayOfMonth/${month+1}/$year", Toast.LENGTH_SHORT)
                        .show()
                }
            DatePickerDialog(this, onDateSetListener, 2023, 4, 5).show()
        }

        btnTimePicker.setOnClickListener {
            val onTimeSetListener =
                TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                    Toast.makeText(this, "You picked ${hour.hours}/${minute.minutes}", Toast.LENGTH_SHORT)
                        .show()
                }
            TimePickerDialog(this, onTimeSetListener, 0, 0, true).show()
        }
    }
}