package kz.kd.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val tvText1: TextView = findViewById(R.id.tv_text1)
        //tvText1.textSize = resources.getDimension(R.dimen.text_size_hello_world)

        val tvText2: TextView = findViewById(R.id.tv_text2)
        tvText2.text = getString(R.string.title_hello_world)

        val cbOne: CheckBox = findViewById(R.id.cb_one)
        cbOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Not checked", Toast.LENGTH_SHORT).show()
            }
        }

        val scOne: SwitchCompat = findViewById(R.id.sc_one)
        scOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Switched", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Not switched", Toast.LENGTH_SHORT).show()
            }
        }

        val etOne: EditText = findViewById(R.id.et_one)
        val tvText3: TextView = findViewById(R.id.tv_text3)
        val btnOne: Button = findViewById(R.id.btn_one)

        btnOne.setOnClickListener {
            tvText3.text = etOne.text
            tvText3.setTextColor(resources.getColor(R.color.purple_200, theme))
            etOne.text.clear()
        }
    }
}