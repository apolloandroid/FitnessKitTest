package com.example.fitnesskittest.view.visits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnesskittest.databinding.FragmentVisitsBinding
import com.example.fitnesskittest.viewmodel.visits.VisitsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class VisitsFragment : Fragment() {

    private lateinit var binding: FragmentVisitsBinding
    private val viewModel: VisitsViewModel by viewModels()
    val adapter = VisitsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVisitsBinding.inflate(inflater, container, true)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setVisitsList()
        setObservers()
        binding.lytRefreshVisits.setOnRefreshListener { viewModel.onRefreshVisits() }
    }

    private fun setObservers() {
        viewModel.visits.onEach { adapter.setVisits(it) }.launchIn(lifecycleScope)

        viewModel.hideLoader.observe(viewLifecycleOwner, {
            binding.lytRefreshVisits.isRefreshing = false
        })
    }

    private fun setVisitsList() {
        val itemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.rvVisits.addItemDecoration(itemDecoration)
        binding.rvVisits.adapter = adapter
    }
}