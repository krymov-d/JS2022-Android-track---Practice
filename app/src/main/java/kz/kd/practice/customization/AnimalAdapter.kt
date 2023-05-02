package kz.kd.practice.customization

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.kd.practice.R

class AnimalAdapter(
    private val clickListener: (animal: Animal) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<Animal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item_cat -> {
                val itemView = inflater.inflate(viewType, parent, false)
                CatViewHolder(itemView)
            }

            R.layout.item_dog -> {
                val itemView = inflater.inflate(viewType, parent, false)
                DogViewHolder(itemView)
            }

            else -> {
                val itemView = inflater.inflate(viewType, parent, false)
                CatViewHolder(itemView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (data[position]) {
            is Cat -> R.layout.item_cat
            is Dog -> R.layout.item_dog
            else -> R.layout.item_cat
        }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CatViewHolder -> holder.bind(data[position], clickListener)
            is DogViewHolder -> holder.bind(data[position], clickListener)
        }
    }

    fun setItems(list: List<Animal>) {
        data.clear()
        data.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }
}