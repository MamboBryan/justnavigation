package com.mambobryan.features.donuts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mambobryan.common.Donut
import com.mambobryan.features.donuts.databinding.ItemDonutBinding

/**
 * JustNavigation
 * @author Brian Odhiambo
 * @email mambobryan@gmail.com
 * Created 7/14/22 at 9:39 AM
 */

fun getDonuts() =
    listOf(
        "Chocolate Frosted",
        "Cinnamon Twist",
        "Cruller",
        "Strawberry Frosted",
        "Old-Fashioned",
        "Jelly",
        "Blueberry",
        "Glazed",
        "Strawberry Frosted",
        "Cream Filled",
        "Sour Cream",
        "Apple Crumb",
    ).map { Donut(it) }


class DonutAdapter : ListAdapter<Donut, DonutAdapter.DonutViewHolder>(DonutComparator) {

    companion object {

        object DonutComparator : DiffUtil.ItemCallback<Donut>() {
            override fun areItemsTheSame(oldItem: Donut, newItem: Donut): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Donut, newItem: Donut): Boolean =
                oldItem == newItem
        }

    }

    private var listener: ((donut: Donut) -> Unit)? = null

    fun onDonutClicked(listener: (donut: Donut) -> Unit){
        this.listener = listener
    }

    inner class DonutViewHolder(private val binding: ItemDonutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val donut = getItem(adapterPosition)
                listener?.invoke(donut)
            }
        }

        fun bind(donut: Donut) {
            binding.tvDonut.text = donut.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonutViewHolder =
        DonutViewHolder(ItemDonutBinding.inflate(LayoutInflater.from(parent.context)))


    override fun onBindViewHolder(holder: DonutAdapter.DonutViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}