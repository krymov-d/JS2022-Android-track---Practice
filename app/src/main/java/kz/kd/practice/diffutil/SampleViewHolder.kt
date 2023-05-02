package kz.kd.practice.diffutil

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kz.kd.practice.R

class SampleViewHolder(itemView: View) : ViewHolder(itemView) {
    private val tvName: TextView = itemView.findViewById(R.id.item_sample_tv)

    fun bind(sample: Sample) {
        tvName.text = sample.name
    }
}