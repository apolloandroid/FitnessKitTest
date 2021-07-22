package com.example.fitnesskittest.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnesskittest.R
import com.example.fitnesskittest.databinding.FragmentMainBinding
import com.example.fitnesskittest.view.main.viewpager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTabs()
    }

    private fun setTabs() {
        val tabsTitles = arrayOf(
            getString(R.string.lessons_tab_title),
            getString(R.string.visits_tab_title)
        )
        viewPagerAdapter = ViewPagerAdapter(tabsTitles.size, childFragmentManager, this.lifecycle)
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.lytTabs, binding.viewPager) { tab, position ->
            tab.text = tabsTitles[position]
        }.attach()
    }
}