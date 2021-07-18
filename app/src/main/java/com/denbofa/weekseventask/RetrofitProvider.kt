package com.denbofa.weekseventask

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitProvider {
    val retrofit = Retrofit.Builder()
            .baseUrl("https://ict-yep-backend.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service: ItemService = retrofit.create(ItemService::class.java)
}