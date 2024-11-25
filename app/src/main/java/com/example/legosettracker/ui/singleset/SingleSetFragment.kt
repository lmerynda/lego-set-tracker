package com.example.legosettracker.ui.singleset

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.legosettracker.LegoSet
import com.example.legosettracker.LegoSetsData
import com.example.legosettracker.databinding.FragmentHomeBinding
import com.example.legosettracker.databinding.FragmentLegoSetBinding
import com.example.legosettracker.ui.home.HomeViewModel
import com.example.legosettracker.ui.home.LegoSetsAdapter

class SingleSetFragment : Fragment() {

    private var _binding: FragmentLegoSetBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SingleSetViewModel
    private lateinit var adapter: SingleSetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLegoSetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SingleSetViewModel::class.java)
        adapter = SingleSetAdapter()

        val legoSetId = arguments?.getString("legoSetId")
        Log.i("SingleSetFragment", "Lego set ID: $legoSetId")
        if (legoSetId != null) {
            viewModel.setSingeSet(legoSetId)
        }

        binding.legoSetItems.layoutManager = LinearLayoutManager(context)
        binding.legoSetItems.adapter = adapter

        viewModel.text.observe(viewLifecycleOwner) { newTitle ->
            binding.legoSetTitle.text = newTitle
        }

        viewModel.items.observe(viewLifecycleOwner) { legoSetItems ->
            adapter.updateItems(legoSetItems)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}