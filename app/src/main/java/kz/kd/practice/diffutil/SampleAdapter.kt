package kz.kd.practice.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kz.kd.practice.R

class SampleAdapter : RecyclerView.Adapter<SampleViewHolder>() {

    private val data = mutableListOf<Sample>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return SampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_sample
    }

    fun setData(newData: List<Sample>) {
        data.clear()
        data.addAll(newData)
        notifyItemRangeChanged(0, data.size)
    }

    fun updateData(updatedData: List<Sample>) {
        val diffItemCallBack = object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return data.size
            }

            override fun getNewListSize(): Int {
                return updatedData.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return data[oldItemPosition].id == updatedData[newItemPosition].id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return data[oldItemPosition].name == updatedData[newItemPosition].name
            }
        }

        val diffResult = DiffUtil.calculateDiff(diffItemCallBack)
        diffResult.dispatchUpdatesTo(this)
    }
}