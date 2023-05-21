package kz.kd.practice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ChipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chips_activity)

        val chipGroup: ChipGroup = findViewById(R.id.chipGroup)
        val arr = listOf("Айбар", "Данат", "Қанат")

        arr.forEach { name ->
            val rootView = layoutInflater.inflate(R.layout.chip_choice, chipGroup, false) as Chip
            rootView.let { chip ->
                chip.id = View.generateViewId()
                chip.text = name
                chip.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        Toast.makeText(this, "${buttonView.text}", Toast.LENGTH_SHORT).show()
                    }
                }
                chipGroup.addView(chip)
            }
        }
    }
}