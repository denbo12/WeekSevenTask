package com.denbofa.weekseventask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.denbofa.weekseventask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myItemAdapter: ItemAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myItemAdapter = ItemAdapter(listOf())
        binding.recycler.adapter = myItemAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.apply {
            getAllItems()
            items.observe(this@MainActivity, {item ->
                myItemAdapter.items = item
                myItemAdapter.notifyDataSetChanged()
            })
        }

        binding.button.setOnClickListener {
            val intent: Intent = Intent(this, StudentsActivity::class.java)
            startActivity(intent)
        }
    }
}