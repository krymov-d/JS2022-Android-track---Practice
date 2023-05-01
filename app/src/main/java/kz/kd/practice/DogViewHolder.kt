package kz.kd.practice

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DogViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private val avatarImageView = itemView.findViewById<ImageView>(R.id.avatarImageView)
    private val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)

    fun bind(item: Animal, clickListener: (name: Animal) -> Unit) {
        item as Dog
        nameTextView.text = item.name
        avatarImageView.setBackgroundResource(item.imageRes)

        nameTextView.setOnClickListener {
            clickListener(item)
        }
    }
}