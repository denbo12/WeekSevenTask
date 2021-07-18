package com.denbofa.weekseventask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denbofa.weekseventask.databinding.StudentListItemBinding

class StudentAdapter(var students: List<StudentModel>): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(val binding: StudentListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(student: StudentModel){
            binding.studentClass.text = student.`class`
            binding.studentName.text = student.name
            binding.studentSeat.text = student.seat.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding: StudentListItemBinding = StudentListItemBinding.inflate(LayoutInflater.from(parent.context))
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students.get(position)
        holder.bind(student)
    }

    override fun getItemCount(): Int {
        return students.size
    }
}