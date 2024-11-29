package com.example.legosettracker.ui.singleset

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.legosettracker.databinding.FragmentLegoSetBinding

class SingleSetFragment : Fragment() {

    private var _binding: FragmentLegoSetBinding? = null
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

        val sharedPreferences = requireContext().getSharedPreferences("lego_sets", android.content.Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this, SingleSetViewModelFactory(sharedPreferences)).get(
            SingleSetViewModel::class.java)

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
            saveLegoSetItems()
        }
    }

    private fun saveLegoSetItems() {
        Log.i("SingleSetFragment", "Saving lego set items")
        viewModel.saveLegoSet()
    }

    override fun onPause() {
        super.onPause()
        saveLegoSetItems()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}