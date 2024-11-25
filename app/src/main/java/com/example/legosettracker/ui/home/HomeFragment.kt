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
import com.example.legosettracker.ui.singleset.LegoSet

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
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

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        adapter = LegoSetsAdapter { singleSet ->
            navigateToDetails(singleSet)
        }

        binding.textHome.text = viewModel.title

        binding.legoSetsView.layoutManager = LinearLayoutManager(context)
        binding.legoSetsView.adapter = adapter

        viewModel.legoSets.observe(viewLifecycleOwner) { legoSets ->
            adapter.updateItems(legoSets)
        }
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