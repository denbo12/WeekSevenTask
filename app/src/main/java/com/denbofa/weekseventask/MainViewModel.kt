package com.denbofa.weekseventask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val items: MutableLiveData<List<ItemModel>> = MutableLiveData()

    fun getAllItems(){
        CoroutineScope(Dispatchers.IO).launch {
            val item: List<ItemModel> = RetrofitProvider.service.getAllItems()
            items.postValue(item)
        }
    }
}