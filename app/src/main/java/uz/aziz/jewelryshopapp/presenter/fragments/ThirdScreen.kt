package uz.aziz.jewelryshopapp.presenter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.aziz.jewelryshopapp.R
import uz.aziz.jewelryshopapp.databinding.FragmentCatalogBinding
import uz.aziz.jewelryshopapp.databinding.FragmentThirdScreenBinding


class ThirdScreen : Fragment(R.layout.fragment_third_screen) {

    var _binding: FragmentThirdScreenBinding? = null
    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentThirdScreenBinding.bind(view)

        var initialNumber = 0
        binding.btn.setOnClickListener {
            binding.tv.text = (++initialNumber).toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}