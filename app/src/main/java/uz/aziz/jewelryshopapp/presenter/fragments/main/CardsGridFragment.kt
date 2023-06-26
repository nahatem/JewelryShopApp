package uz.aziz.jewelryshopapp.presenter.fragments.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.aziz.jewelryshopapp.R
import uz.aziz.jewelryshopapp.data.JewelryData
import uz.aziz.jewelryshopapp.databinding.FragmentCardsGridBinding

import uz.aziz.jewelryshopapp.presenter.fragments.main.adapter.JewelGridAdapter


class CardsGridFragment : Fragment(R.layout.fragment_cards_grid) {

    private var _binding: FragmentCardsGridBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCardsGridBinding.bind(view)

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