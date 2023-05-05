package kz.kd.practice

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class FirstDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val customView: View = layoutInflater.inflate(R.layout.dialog_custom, null, false)
        val dialog = AlertDialog.Builder(context).apply {
            setView(customView)
        }.create()
        with(customView) {
            findViewById<TextView>(R.id.title).text = "Custom Title"
            findViewById<TextView>(R.id.subtitle).text = "Custom SubTitle"
            findViewById<Button>(R.id.closeButton).setOnClickListener {
                dialog.dismiss()
            }
        }
        return dialog
    }
}