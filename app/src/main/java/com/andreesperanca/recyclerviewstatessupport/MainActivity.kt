package com.andreesperanca.recyclerviewstatessupport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.andreesperanca.recyclerviewstatessupport.databinding.ActvityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActvityMainBinding.inflate(layoutInflater)
    }

    private lateinit var recyclerView: CustomRecyclerViewEmptySupport
    private val adapter by lazy {
        FruitsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = listOf("Andre", "João", "Pedro", "Ruth")

        /** SETUP RECYCLERVIEW **/
        recyclerView = binding.myRecyclerView
        recyclerView.rv.adapter = adapter
        recyclerView.rv.layoutManager = LinearLayoutManager(this, VERTICAL, false)


        binding.btnEmptyState.setOnClickListener {
            recyclerView.rState = RecyclerStates.Empty()
            recyclerView.updateState()
        }
        binding.btnLoadingState.setOnClickListener {
            recyclerView.rState = RecyclerStates.Loading()
            recyclerView.updateState()
        }
        binding.btnSuccessState.setOnClickListener {
            adapter.updateList(data)
            recyclerView.rState = RecyclerStates.Success()
            recyclerView.updateState()
        }
    }
}