package uz.aziz.jewelryshopapp.presenter.fragments.catalog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.aziz.jewelryshopapp.R
import uz.aziz.jewelryshopapp.databinding.CatalogCategoryItemBinding
import uz.aziz.jewelryshopapp.model.CategoryItem
import uz.aziz.jewelryshopapp.utils.log

class CategoryListAdapter(
    private val onItemClicked: (CategoryItem) -> Unit
) : ListAdapter<CategoryItem, CategoryListAdapter.CategoryViewHolder>(DiffCallback) {

    class CategoryViewHolder(private val binding: CatalogCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryItem) {
            binding.imageCategory.setImageResource(item.icon)
            binding.textTitle.text = item.categoryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CatalogCategoryItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<CategoryItem>() {
            override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
                return oldItem.categoryName == newItem.categoryName
            }
        }
    }
}