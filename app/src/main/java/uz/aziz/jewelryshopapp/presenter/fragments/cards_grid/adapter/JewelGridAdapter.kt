package uz.aziz.jewelryshopapp.presenter.fragments.cards_grid.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.aziz.jewelryshopapp.databinding.JewelCardItemBinding
import uz.aziz.jewelryshopapp.model.JewelItem


class JewelGridAdapter(
    private val onItemClicked: (JewelItem) -> Unit
) : ListAdapter<JewelItem, JewelGridAdapter.JewelViewHolder>(DiffCallback) {

    class JewelViewHolder(private var binding: JewelCardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: JewelItem) {
            Log.d("myAdapter", "bind")
            binding.itemImg.setImageResource(item.img)
            binding.itemPrice.text = "${item.price}$"
            binding.itemDesc.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JewelViewHolder {
        return JewelViewHolder(
            JewelCardItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: JewelViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<JewelItem>() {
            override fun areItemsTheSame(oldItem: JewelItem, newItem: JewelItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: JewelItem, newItem: JewelItem): Boolean {
                return oldItem.img == newItem.img
            }
        }
    }


}