package com.denbofa.weekseventask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val items: MutableLiveData<List<ItemModel>> = MutableLiveData()
    val students: MutableLiveData<List<StudentModel>> = MutableLiveData()
    val addstudent: MutableLiveData<List<StudentModel>> = MutableLiveData()

    fun getAllItems(){
        CoroutineScope(Dispatchers.IO).launch {
            val item: List<ItemModel> = RetrofitProvider.service.getAllItems()
            items.postValue(item)
        }
    }

    fun getAllStudents(){
        CoroutineScope(Dispatchers.IO).launch {
            val student: List<StudentModel> = RetrofitProvider.service2.getAllStudents()
            students.postValue(student)
        }
    }

    fun pushPost(student: StudentModel){
       CoroutineScope(Dispatchers.IO).launch {
           val newStudent: List<StudentModel> = RetrofitProvider.service2.addStudent(student)
           addstudent.postValue(newStudent)
       }
    }
}