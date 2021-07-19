package com.denbofa.weekseventask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.denbofa.weekseventask.databinding.ActivityStudentsBinding
import retrofit2.http.POST

class StudentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentsBinding
    private lateinit var myStudentAdapter: StudentAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myStudentAdapter = StudentAdapter(listOf())
        binding.recycler2.adapter = myStudentAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.apply {
            getAllStudents()
            students.observe(this@StudentsActivity, {student->
                myStudentAdapter.students = student
                myStudentAdapter.notifyDataSetChanged()
            })
        }

       binding.submit.setOnClickListener {
           var name: String = binding.insertedName.text.toString()
           var seat: Int = binding.insertedSeat.text.toString().toInt()
           var studentClass: String = binding.insertedClass.text.toString()

           var myPost = StudentModel(studentClass, name, seat)
           viewModel.apply {
               viewModel.pushPost(myPost)
               addstudent.observe(this@StudentsActivity, {response ->
                   myStudentAdapter.students = response
                   myStudentAdapter.notifyDataSetChanged()
               })
           }


       }
    }
}