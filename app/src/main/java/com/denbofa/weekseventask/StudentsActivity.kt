package com.denbofa.weekseventask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.denbofa.weekseventask.databinding.ActivityStudentsBinding
import retrofit2.http.POST
import retrofit2.http.Tag

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

           if (name.isNotEmpty() && studentClass.isNotEmpty() && seat != null){
               var myPost = StudentModel(studentClass, name, seat)
               viewModel.pushPost(myPost)
               Toast.makeText(this, "successful ", Toast.LENGTH_SHORT).show()
           }else {
               Toast.makeText(this, "fill all fields ", Toast.LENGTH_SHORT).show()
           }
       }
    }
}