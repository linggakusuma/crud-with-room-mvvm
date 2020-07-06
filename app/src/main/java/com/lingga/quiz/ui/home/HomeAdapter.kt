package com.lingga.quiz.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lingga.quiz.data.local.entities.CollegeStudent
import com.lingga.quiz.databinding.ListItemActivitiesBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var collegeStudents = emptyList<CollegeStudent>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        return HomeViewHolder(ListItemActivitiesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = collegeStudents.size

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        val collegeStudent = collegeStudents[position]
        holder.bind(collegeStudent)
    }

    inner class HomeViewHolder(private val binding: ListItemActivitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(collegeStudent: CollegeStudent) {
            binding.apply {
                item = collegeStudent
                executePendingBindings()
            }
        }
    }

    internal fun setCollegeStudents(collegeStudents: List<CollegeStudent>) {
        this.collegeStudents = collegeStudents
        notifyDataSetChanged()
    }
}