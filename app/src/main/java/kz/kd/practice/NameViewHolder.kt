package kz.kd.practice

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView = itemView.findViewById<Button>(R.id.nameTextView)

    fun bind(item: String, clickListener: (name: String) -> Unit) {
        nameTextView.text = item
        nameTextView.setOnClickListener {
            clickListener(item)
        }
    }
}