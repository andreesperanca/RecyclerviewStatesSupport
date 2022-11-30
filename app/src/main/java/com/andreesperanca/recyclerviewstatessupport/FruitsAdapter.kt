package com.andreesperanca.recyclerviewstatessupport

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.recyclerviewstatessupport.FruitsAdapter.*
import com.andreesperanca.recyclerviewstatessupport.databinding.FruitItemBinding

class FruitsAdapter : RecyclerView.Adapter<FruitsViewHolder>() {

    private var fruitList: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val binding = FruitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FruitsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.bind(fruitList[position])
    }

    override fun getItemCount(): Int = fruitList.size

    fun updateList(newList: List<String>) {
        newList.let {
            fruitList = newList
            notifyItemChanged(newList.size)
        }
    }

    inner class FruitsViewHolder(private val binding: FruitItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(s: String) {
            binding.tvFruitName.text = s
        }
    }
}