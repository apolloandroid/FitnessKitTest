package com.example.fitnesskittest.view.main.viewpager

import androidx.fragment.app.Fragment
import com.example.fitnesskittest.view.lessons.LessonsFragment
import com.example.fitnesskittest.view.visits.VisitsFragment
import com.example.fitnesskittest.R


class ViewPagerFragmentFactory {
    companion object {
        fun newInstance(position: Int): Fragment {
            return when (position) {
                0 -> LessonsFragment()
                else -> VisitsFragment()
            }
        }
    }
}