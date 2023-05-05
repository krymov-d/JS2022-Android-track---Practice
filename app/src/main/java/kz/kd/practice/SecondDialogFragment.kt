package kz.kd.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class SecondDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val customView = inflater.inflate(R.layout.dialog_custom, null)

        with(customView) {
            findViewById<TextView>(R.id.title).text = "Custom Title"
            findViewById<TextView>(R.id.subtitle).text = "Custom Subtitle"
            findViewById<Button>(R.id.closeButton).setOnClickListener {
                dismiss()
            }
        }

        return customView
    }
}