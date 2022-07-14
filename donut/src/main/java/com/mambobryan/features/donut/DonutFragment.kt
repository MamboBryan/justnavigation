package com.mambobryan.features.donut

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.mambobryan.common.Donut
import com.mambobryan.features.donut.databinding.FragmentDonutBinding

class DonutFragment : Fragment() {

    private var _binding: FragmentDonutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDonutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: get the donut from the donuts fragment and show donut success

    }

    fun showDonutSuccess(donut: Donut) {

        binding.tvDonutName.text = donut.name

        Snackbar.make(binding.tvDonutName, donut.name, Snackbar.LENGTH_SHORT).apply {
            this.setBackgroundTint(Color.GREEN)
            this.show()
        }

    }

}