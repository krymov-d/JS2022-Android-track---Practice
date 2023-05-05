package kz.kd.practice

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

class MainActivity : AppCompatActivity() {

    private lateinit var btnDatePicker: Button
    private lateinit var btnTimePicker: Button
    private lateinit var btnSimpleAlertDialog: Button
    private lateinit var btnAlertDialogWithList: Button
    private lateinit var btnMultipleChoice: Button
    private lateinit var btnSingleChoice: Button
    private lateinit var btnCustomDialog: Button
    private lateinit var btnDialogFragment: Button

    private val students = arrayOf(
        "Student A",
        "Student B",
        "Student C",
        "Student D",
        "Student E",
        "Student F",
        "Student G",
        "Student H"
    )
    private val studentsState = booleanArrayOf(true, false, true, false, true, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initClickListeners()
    }

    private fun initViews() {
        btnDatePicker = findViewById(R.id.btn_date_picker)
        btnTimePicker = findViewById(R.id.btn_time_picker)
        btnSimpleAlertDialog = findViewById(R.id.btn_alert_dialog_simple)
        btnAlertDialogWithList = findViewById(R.id.btn_alert_dialog_with_list)
        btnMultipleChoice = findViewById(R.id.btn_alert_dialog_multiple_choice)
        btnSingleChoice = findViewById(R.id.btn_alert_dialog_single_choice)
        btnCustomDialog = findViewById(R.id.btn_alert_dialog_custom)
        btnDialogFragment = findViewById(R.id.btn_dialog_fragment)
    }

    private fun initClickListeners() {
        btnDatePicker.setOnClickListener {
            val onDateSetListener =
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    Toast.makeText(
                        this,
                        "You picked $dayOfMonth/${month + 1}/$year",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            DatePickerDialog(this, onDateSetListener, 2023, 4, 5).show()
        }

        btnTimePicker.setOnClickListener {
            val onTimeSetListener =
                TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                    Toast.makeText(
                        this,
                        "You picked ${hour.hours}/${minute.minutes}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            TimePickerDialog(this, onTimeSetListener, 0, 0, true).show()
        }

        btnSimpleAlertDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Simple Alert")
                .setPositiveButton(
                    "Positive button"
                ) { _, which ->
                    Toast.makeText(this, "$which is pressed", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(
                    "Negative button"
                ) { _, which ->
                    Toast.makeText(this, "$which is pressed", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton(
                    "Neutral button"
                ) { _, which ->
                    Toast.makeText(this, "$which is pressed", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        btnAlertDialogWithList.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("List of students")
                setItems(students) { _, itemIndex ->
                    Toast.makeText(
                        this@MainActivity,
                        "${students[itemIndex]} is pressed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.show()
        }

        btnMultipleChoice.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("List of students")
                setMultiChoiceItems(students, studentsState) { _, itemIndex, itemState ->
                    Toast.makeText(
                        this@MainActivity,
                        "${students[itemIndex]} is checked $itemState",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.show()
        }

        btnSingleChoice.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("List of students")
                setSingleChoiceItems(students, 0) { _, checkedIndex ->
                    Toast.makeText(
                        this@MainActivity,
                        "${students[checkedIndex]} is checked",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.show()
        }

        btnCustomDialog.setOnClickListener {
            val customView: View = layoutInflater.inflate(R.layout.dialog_custom, null, false)
            val dialog = AlertDialog.Builder(this).apply {
                setView(customView)
            }.create()
            with(customView) {
                findViewById<TextView>(R.id.title).text = "Custom Title"
                findViewById<TextView>(R.id.subtitle).text = "Custom SubTitle"
                findViewById<Button>(R.id.closeButton).setOnClickListener {
                    dialog.dismiss()
                }
            }
            dialog.show()
        }

        btnDialogFragment.setOnClickListener {
            FirstDialogFragment().show(supportFragmentManager, null)
        }
    }
}