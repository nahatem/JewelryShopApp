package uz.aziz.jewelryshopapp.presenter.fragments.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.aziz.jewelryshopapp.R
import uz.aziz.jewelryshopapp.data.JewelryData
import uz.aziz.jewelryshopapp.databinding.FragmentMainBinding
import uz.aziz.jewelryshopapp.presenter.fragments.main.adapter.JewelGridAdapter


class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        val adapter = JewelGridAdapter() {
        }

        binding.recyclerView.adapter = adapter
        adapter.submitList(JewelryData.JewelryList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}