package uz.aziz.jewelryshopapp.presenter.fragments.catalog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.aziz.jewelryshopapp.R
import uz.aziz.jewelryshopapp.data.CategoryData
import uz.aziz.jewelryshopapp.databinding.FragmentCatalogBinding
import uz.aziz.jewelryshopapp.presenter.fragments.catalog.adapter.CategoryListAdapter
import uz.aziz.jewelryshopapp.utils.log


class CatalogMainFragment : Fragment(R.layout.fragment_catalog) {

    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCatalogBinding.bind(view)

        val adapter = CategoryListAdapter() {
            childFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.category_fragment, PageRingsFragment())
                .commit()
        }

        binding.rvCategoryList.adapter = adapter
        adapter.submitList(CategoryData.categoryList)
        log("CatalogFragment: onViewCreated")
    }

    override fun onPause() {
        super.onPause()
        log("CatalogFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        log("CatalogFragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        log("CatalogFragment: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("CatalogFragment: onDestroy")
    }
}