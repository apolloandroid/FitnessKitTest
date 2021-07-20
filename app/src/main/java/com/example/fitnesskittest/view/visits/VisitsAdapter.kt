package com.example.fitnesskittest.view.visits

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskittest.databinding.VisitItemBinding
import com.example.fitnesskittest.model.entity.Visit
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class VisitsAdapter : ListAdapter<Visit, VisitsAdapter.VisitViewHolder>(AlbumsDiffCallBack()) {

    private val visits = mutableListOf<Visit>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = VisitItemBinding.inflate(layoutInflater, parent, false)
        return VisitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VisitViewHolder, position: Int) {
        holder.bind(visits[position])
    }

    override fun getItemCount() = visits.size

    fun setVisits(visits: List<Visit>) {
        this.visits.clear()
        this.visits.addAll(visits)
        notifyDataSetChanged()
    }

    class VisitViewHolder(private val binding: VisitItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(visit: Visit) {
            binding.tvVisitName.text = visit.name
            binding.tvVisitDate.text = parseVisitDate(visit.date)
        }

        private fun parseVisitDate(currentDate: String): String {
            val targetDateFormat = "dd.MM.yyyy"
            val formatter = DateTimeFormatter.ofPattern(targetDateFormat)
            return LocalDate.parse(currentDate).format(formatter)
        }
    }

    private class AlbumsDiffCallBack : DiffUtil.ItemCallback<Visit>() {
        override fun areItemsTheSame(oldItem: Visit, newItem: Visit): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Visit, newItem: Visit): Boolean =
            oldItem == newItem
    }
}