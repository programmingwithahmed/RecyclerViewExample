package com.abc.recyclerviewexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abc.recyclerviewexample.databinding.RecylerItemUserBinding
import com.abc.recyclerviewexample.model.User

class UsersAdapter(private val items: List<User>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    var onClickItem: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecylerItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: RecylerItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: User, position: Int) {

            binding.tvName.text = item.name
            binding.tvAge.text = item.age.toString()

            binding.layoutRoot.setOnClickListener {
                onClickItem(position)
            }

        }

    }
}