package com.doiliomatsinhe.dcvilains.adapter


import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.doiliomatsinhe.dcvilains.model.Villain

class VillainAdapter (private val clickListener: VillainClickListener) :
    PagingDataAdapter<Villain, RecyclerView.ViewHolder>(VillainDiffUtilCallback()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let { (holder as VillainViewHolder).bind(it, clickListener) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VillainViewHolder.from(parent)
    }

}

class VillainDiffUtilCallback : DiffUtil.ItemCallback<Villain>() {
    override fun areItemsTheSame(oldItem: Villain, newItem: Villain): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Villain, newItem: Villain): Boolean {
        return oldItem == newItem
    }
}

class VillainClickListener (val clickListener: (villain: Villain) -> Unit) {
    fun onClick(villain: Villain) = clickListener(villain)
}