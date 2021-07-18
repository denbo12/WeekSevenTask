package com.denbofa.weekseventask

import retrofit2.http.GET
import retrofit2.http.POST

interface StudentService {
    @GET("students")
    suspend fun getAllStudents(): List<StudentModel>


}