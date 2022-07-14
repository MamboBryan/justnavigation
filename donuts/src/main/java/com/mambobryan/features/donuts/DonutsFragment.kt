package com.mambobryan.features.donuts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.mambobryan.features.donuts.databinding.FragmentDonutsBinding

class DonutsFragment : Fragment() {

    private var _binding: FragmentDonutsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDonutsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DonutAdapter()
        adapter.submitList(getDonuts())
        adapter.onDonutClicked { donut ->
            // TODO: navigate to view donut
            Snackbar.make(binding.rvDonuts, donut.name, Snackbar.LENGTH_SHORT).show()
        }

        binding.rvDonuts.adapter = adapter

    }

}