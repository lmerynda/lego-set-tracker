package com.example.legosettracker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.legosettracker.R
import com.example.legosettracker.databinding.FragmentHomeBinding
import com.example.legosettracker.LegoSet

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: LegoSetsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireContext().getSharedPreferences("lego_sets", android.content.Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this, HomeViewModelFactory(sharedPreferences)).get(HomeViewModel::class.java)

        adapter = LegoSetsAdapter { legoSet ->
            navigateToDetails(legoSet)
        }

        binding.legoSetsView.layoutManager = LinearLayoutManager(context)
        binding.legoSetsView.adapter = adapter

        viewModel.legoSets.observe(viewLifecycleOwner) { legoSets ->
            adapter.updateItems(legoSets)
        }

        binding.textHome.text = viewModel.title
    }

    private fun navigateToDetails(legoSet: LegoSet) {
        val bundle = Bundle().apply {
            putString("legoSetId", legoSet.title)
        }
        findNavController().navigate(R.id.navigation_fragment_lego_set, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}