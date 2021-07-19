package com.denbofa.weekseventask

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface StudentService {
    @GET("students")
    suspend fun getAllStudents(): List<StudentModel>

    @POST("students")
    suspend fun addStudent(@Body newStudent: StudentModel): List<StudentModel>
}