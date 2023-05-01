package kz.kd.practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NameAdapter(
    private val clickListener: (name: String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_name, parent, false)
        return NameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NameViewHolder).bind(data[position], clickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setItems(list: List<String>) {
        data.clear()
        data.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }
}