package com.example.fitnesskittest.view.lessons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.fitnesskittest.databinding.FragmentLessonsBinding
import com.example.fitnesskittest.viewmodel.lessons.LessonsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@AndroidEntryPoint
class LessonsFragment : Fragment() {

    private lateinit var binding: FragmentLessonsBinding
    private val viewModel: LessonsViewModel by viewModels()

    @Inject
    lateinit var adapter: LessonsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLessonsBinding.inflate(inflater, container, true)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLessonsList()
        setObservers()
        binding.lytRefreshLessons.setOnRefreshListener { viewModel.onRefreshLessons() }
    }

    private fun setObservers() {
        viewModel.lessonsHistory.onEach{ adapter.setLessons(it) }.launchIn(lifecycleScope)

        viewModel.hideLoader.observe(viewLifecycleOwner, {
            binding.lytRefreshLessons.isRefreshing = false
        })
    }

    private fun setLessonsList() {
        binding.rvLessons.adapter = adapter
    }
}