package com.kotlinorderapp.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kotlinorderapp.R
import com.kotlinorderapp.databinding.FragmentStartOrderBinding

class StartOrderFragment : Fragment() {
    private var _binding: FragmentStartOrderBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartOrderBinding.inflate(inflater, container, false)

        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_startOrderFragment_to_coffeeMenuFragment)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}